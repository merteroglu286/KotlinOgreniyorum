package com.merteroglu286.kotlinogreniyorum.domain.uce_cases.read_progress

import com.merteroglu286.kotlinogreniyorum.domain.repository.Repository
import kotlinx.coroutines.flow.Flow

class ReadProgressUseCase(
    private val repository: Repository
) {
    operator fun invoke(): Flow<Float> {
        return repository.readProgress()
    }
}