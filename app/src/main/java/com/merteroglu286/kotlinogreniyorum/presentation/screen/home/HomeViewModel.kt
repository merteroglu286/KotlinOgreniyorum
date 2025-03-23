package com.merteroglu286.kotlinogreniyorum.presentation.screen.home

import android.util.Log
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
): ViewModel() {

    private val _moduleListState = MutableStateFlow<ModuleListState>(ModuleListState())
    val moduleListState: StateFlow<ModuleListState> = _moduleListState

    init {
        loadModules()
    }

    private fun loadModules() {
        viewModelScope.launch {
            useCases.getModulesUseCase()
                .onEach { result ->
                    when (result) {
                        is Resource.Loading -> {
                            Log.d("mertLog", "Loading")
                            _moduleListState.value = ModuleListState(isLoading = true)
                        }
                        is Resource.Success -> {
                            Log.d("mertLog", "Success")
                            _moduleListState.value = ModuleListState(modules = result.data ?: emptyList())
                        }
                        is Resource.Error -> {
                            Log.d("mertLog", "Error")
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