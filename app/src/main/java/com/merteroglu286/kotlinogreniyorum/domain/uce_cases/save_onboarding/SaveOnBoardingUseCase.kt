package com.merteroglu286.kotlinogreniyorum.domain.uce_cases.save_onboarding

import com.merteroglu286.kotlinogreniyorum.domain.repository.Repository

class SaveOnBoardingUseCase(
    private val repository: Repository
) {
    suspend operator fun invoke(isComplete: Boolean){
        repository.saveOnBoardingState(isComplete)
    }
}