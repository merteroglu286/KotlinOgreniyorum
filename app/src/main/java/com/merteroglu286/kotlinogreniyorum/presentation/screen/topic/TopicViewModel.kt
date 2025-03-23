package com.merteroglu286.kotlinogreniyorum.presentation.screen.topic

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.merteroglu286.kotlinogreniyorum.domain.Resource
import com.merteroglu286.kotlinogreniyorum.domain.model.Topic
import com.merteroglu286.kotlinogreniyorum.domain.uce_cases.UseCases
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch

class TopicViewModel
    (
    private val useCases: UseCases
) : ViewModel() {

    private val _topicListState = MutableStateFlow<TopicListState>(TopicListState())
    val topicListState: StateFlow<TopicListState> = _topicListState

    init {
        loadTopics(1)
    }

    private fun loadTopics(moduleId: Int) {
        viewModelScope.launch {
            useCases.getTopicsUseCase(moduleId)
                .onEach { result ->
                    when (result) {
                        is Resource.Loading -> {
                            Log.d("mertLog", "Loading")
                            _topicListState.value = TopicListState(isLoading = true)
                        }
                        is Resource.Success -> {
                            Log.d("mertLog", "Success")
                            _topicListState.value = TopicListState(topics = result.data ?: emptyList())
                        }
                        is Resource.Error -> {
                            Log.d("mertLog", "Error")
                            _topicListState.value = TopicListState(
                                error = result.message ?: "Unknown error"
                            )
                        }
                    }
                }.launchIn(viewModelScope)
        }
    }

    data class TopicListState(
        val isLoading: Boolean = false,
        val topics: List<Topic> = emptyList(),
        val error: String = ""
    )
}