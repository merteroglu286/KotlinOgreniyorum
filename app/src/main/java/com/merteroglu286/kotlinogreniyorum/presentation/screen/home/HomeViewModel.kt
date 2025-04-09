package com.merteroglu286.kotlinogreniyorum.presentation.screen.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.merteroglu286.kotlinogreniyorum.domain.Resource
import com.merteroglu286.kotlinogreniyorum.domain.model.Module
import com.merteroglu286.kotlinogreniyorum.domain.uce_cases.UseCases
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch

class HomeViewModel(
    private val useCases: UseCases
) : ViewModel() {

    private val _moduleListState =
        MutableStateFlow<ModuleListState>(ModuleListState(isLoading = true))
    val moduleListState: StateFlow<ModuleListState> = _moduleListState

    private val _progress = MutableStateFlow(0f)
    val progress: StateFlow<Float> = _progress

    private val _completedTopicList = MutableStateFlow<List<Int>>(emptyList())
    val completedTopicList: StateFlow<List<Int>> = _completedTopicList

    private val _completedQuestionList = MutableStateFlow<List<Int>>(emptyList())
    val completedQuestionList: StateFlow<List<Int>> = _completedQuestionList

    init {
        loadModules()

        viewModelScope.launch {
            useCases.readProgressUseCase().collect { _progress.value = it }
        }

        viewModelScope.launch {
            useCases.readCompletedTopicsUseCase().collect { list ->
                _completedTopicList.value = list
            }
        }

        viewModelScope.launch {
            useCases.readCompletedQuestionsUseCase().collect { list ->
                _completedQuestionList.value = list
            }
        }
    }

    fun loadModules() {
        viewModelScope.launch {
            useCases.getModulesUseCase()
                .onEach { result ->
                    when (result) {
                        is Resource.Loading -> {
                            _moduleListState.value = ModuleListState(isLoading = true)
                        }

                        is Resource.Success -> {
                            useCases.saveModuleCountUseCase(result.data?.size ?: 0)
                            _moduleListState.value =
                                ModuleListState(modules = result.data ?: emptyList())
                        }

                        is Resource.Error -> {
                            _moduleListState.value = ModuleListState(
                                error = result.message ?: "Unknown error"
                            )
                        }
                    }
                }.launchIn(viewModelScope)
        }
    }

    data class ModuleListState(
        val isLoading: Boolean = false,
        val modules: List<Module> = emptyList(),
        val error: String = ""
    )
}