package com.merteroglu286.kotlinogreniyorum.domain.uce_cases.read_completed_topics

import com.merteroglu286.kotlinogreniyorum.domain.repository.Repository
import kotlinx.coroutines.flow.Flow

class ReadCompletedTopicsUseCase(
    private val repository: Repository
) {
    operator fun invoke(): Flow<List<Int>> {
        return repository.readModuleIdListForTopic()
    }
}