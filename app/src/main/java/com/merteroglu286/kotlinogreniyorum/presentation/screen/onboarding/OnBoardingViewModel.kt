package com.merteroglu286.kotlinogreniyorum.presentation.screen.onboarding

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.merteroglu286.kotlinogreniyorum.domain.uce_cases.UseCases
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class OnBoardingViewModel(
    private val useCases: UseCases
): ViewModel() {

    fun saveOnBoardingState(isComplete: Boolean){
        viewModelScope.launch(Dispatchers.IO) {
            useCases.saveOnBoardingUseCase(isComplete)
        }
    }
}