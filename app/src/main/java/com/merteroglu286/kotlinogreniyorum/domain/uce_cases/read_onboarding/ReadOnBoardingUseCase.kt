package com.merteroglu286.kotlinogreniyorum.domain.uce_cases.read_onboarding

import com.merteroglu286.kotlinogreniyorum.domain.repository.Repository
import kotlinx.coroutines.flow.Flow

class ReadOnBoardingUseCase(
    private val repository: Repository
) {
    operator fun invoke(): Flow<Boolean> {
        return repository.readOnBoardingState()
    }
}