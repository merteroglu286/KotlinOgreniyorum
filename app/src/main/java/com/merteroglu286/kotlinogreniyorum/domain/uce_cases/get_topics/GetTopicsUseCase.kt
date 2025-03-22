package com.merteroglu286.kotlinogreniyorum.domain.uce_cases.get_topics

import com.merteroglu286.kotlinogreniyorum.domain.Resource
import com.merteroglu286.kotlinogreniyorum.domain.model.Topic
import com.merteroglu286.kotlinogreniyorum.domain.repository.TopicsRepository
import kotlinx.coroutines.flow.Flow

class GetTopicsUseCase(
    private val repository: TopicsRepository
) {
    suspend operator fun invoke(moduleId: Int): Flow<Resource<List<Topic>>> {
        return repository.getTopics(moduleId)
    }
}