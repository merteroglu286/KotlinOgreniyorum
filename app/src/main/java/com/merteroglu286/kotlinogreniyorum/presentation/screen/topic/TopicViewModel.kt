package com.merteroglu286.kotlinogreniyorum.presentation.screen.topic

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.merteroglu286.kotlinogreniyorum.domain.Resource
import com.merteroglu286.kotlinogreniyorum.domain.model.Topic
import com.merteroglu286.kotlinogreniyorum.domain.uce_cases.UseCases
import com.merteroglu286.kotlinogreniyorum.utility.Constants.TOPIC_ARGUMENT_KEY
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.firstOrNull
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch

class TopicViewModel(
    private val useCases: UseCases,
    private val savedStateHandle: SavedStateHandle
) : ViewModel() {

    private val _topicListState = MutableStateFlow<TopicListState>(TopicListState(isLoading = true))
    val topicListState: StateFlow<TopicListState> = _topicListState

    private var moduleId: Int = 0

    init {
        viewModelScope.launch(Dispatchers.IO) {
            moduleId = savedStateHandle.get<Int>(TOPIC_ARGUMENT_KEY) ?: 0
            loadTopics(moduleId)
        }
    }


    fun loadTopics(moduleId: Int) {
        viewModelScope.launch {
            useCases.getTopicsUseCase(moduleId)
                .onEach { result ->
                    when (result) {
                        is Resource.Loading -> {
                            _topicListState.value = TopicListState(isLoading = true)
                        }
                        is Resource.Success -> {
                            _topicListState.value = TopicListState(topics = result.data ?: emptyList())
                        }
                        is Resource.Error -> {
                            _topicListState.value = TopicListState(
                                error = result.message ?: "Unknown error"
                            )
                        }
                    }
                }.launchIn(viewModelScope)
        }
    }

    private suspend fun getModuleCount(): Int {
        return useCases.readModuleCountUseCase().first()
    }

    private suspend fun progressStepPoint(): Float {
        val moduleCount = getModuleCount()
        val point = if (moduleCount == 0) 0f else ((100f / (moduleCount * 2)))
        return point
    }

    fun saveTopics() {
        viewModelScope.launch {
            val completedTopics = useCases.readCompletedTopicsUseCase().firstOrNull() ?: emptyList()

            if (!completedTopics.contains(moduleId)) {
                val oldProgress = useCases.readProgressUseCase().firstOrNull() ?: 0f
                val newProgress = oldProgress + progressStepPoint()
                useCases.saveProgressUseCase(newProgress)
                useCases.saveCompletedTopicsUseCase(moduleId)
            }
        }
    }

    data class TopicListState(
        val isLoading: Boolean = false,
        val topics: List<Topic> = emptyList(),
        val error: String = ""
    )
}