package com.merteroglu286.kotlinogreniyorum.presentation.screen.splash

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.merteroglu286.kotlinogreniyorum.domain.Resource
import com.merteroglu286.kotlinogreniyorum.domain.model.Module
import com.merteroglu286.kotlinogreniyorum.domain.model.Topic
import com.merteroglu286.kotlinogreniyorum.domain.uce_cases.UseCases
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

private const val TAG = "mertLog2"

class SplashViewModel(
    private val useCases: UseCases
) : ViewModel() {

    private val _moduleListState = MutableStateFlow<ModuleListState>(ModuleListState())
    val moduleListState: StateFlow<ModuleListState> = _moduleListState

    private val _topicListState = MutableStateFlow<TopicListState>(TopicListState())
    val topicListState: StateFlow<TopicListState> = _topicListState


    fun loadModules() {
        viewModelScope.launch {
            try {
                useCases.getModulesUseCase()
                    .catch { exception ->
                        Log.e(TAG, "Exception in loadModules flow: ${exception.message}", exception)
                        _moduleListState.value = ModuleListState(
                            error = "Flow exception: ${exception.message ?: "Bilinmeyen hata"}"
                        )
                    }
                    .onEach { result ->
                        Log.d(TAG, "Received result: ${result.data}")
                        when (result) {
                            is Resource.Loading -> {
                                Log.d(TAG, "Loading modules...")
                                _moduleListState.value = ModuleListState(isLoading = true)
                            }
                            is Resource.Success -> {
                                Log.d(TAG, "Modules loaded successfully: ${result.data?.size} items")
                                _moduleListState.value = ModuleListState(modules = result.data ?: emptyList())
                            }
                            is Resource.Error -> {
                                Log.e(TAG, "Error loading modules: ${result.message}")
                                _moduleListState.value = ModuleListState(
                                    error = result.message ?: "Bilinmeyen hata"
                                )
                            }
                        }
                    }.launchIn(viewModelScope)
            } catch (e: Exception) {
                Log.e(TAG, "Uncaught exception in loadModules: ${e.message}", e)
                _moduleListState.value = ModuleListState(
                    error = "ViewModel exception: ${e.message ?: "Bilinmeyen hata"}"
                )
            }
        }
    }

    fun loadTopics(moduleId: Int) {
        viewModelScope.launch {
            try {
                useCases.getTopicsUseCase(moduleId)
                    .catch { exception ->
                        Log.e(TAG, "Exception in loadModules flow: ${exception.message}", exception)
                        _topicListState.value = TopicListState(
                            error = "Flow exception: ${exception.message ?: "Bilinmeyen hata"}"
                        )
                    }
                    .onEach { result ->
                        Log.d(TAG, "Received result: ${result.data}")
                        when (result) {
                            is Resource.Loading -> {
                                Log.d(TAG, "Loading modules...")
                                _topicListState.value = TopicListState(isLoading = true)
                            }
                            is Resource.Success -> {
                                Log.d(TAG, "Modules loaded successfully: ${result.data?.size} items")
                                _topicListState.value = TopicListState(topics = result.data ?: emptyList())
                            }
                            is Resource.Error -> {
                                Log.e(TAG, "Error loading modules: ${result.message}")
                                _topicListState.value = TopicListState(
                                    error = result.message ?: "Bilinmeyen hata"
                                )
                            }
                        }
                    }.launchIn(viewModelScope)
            } catch (e: Exception) {
                Log.e(TAG, "Uncaught exception in loadModules: ${e.message}", e)
                _topicListState.value = TopicListState(
                    error = "ViewModel exception: ${e.message ?: "Bilinmeyen hata"}"
                )
            }
        }
    }

    data class ModuleListState(
        val isLoading: Boolean = false,
        val modules: List<Module> = emptyList(),
        val error: String = ""
    )

    data class TopicListState(
        val isLoading: Boolean = false,
        val topics: List<Topic> = emptyList(),
        val error: String = ""
    )

    private val _onBoardingCompleted = MutableStateFlow(false)
    val onBoardingCompleted : StateFlow<Boolean> = _onBoardingCompleted

    init {
        viewModelScope.launch {
            _onBoardingCompleted.value =
                useCases.readOnBoardingUseCase().stateIn(viewModelScope).value
        }

    }
}