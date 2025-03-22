package com.merteroglu286.kotlinogreniyorum.domain.repository

import com.merteroglu286.kotlinogreniyorum.domain.Resource
import com.merteroglu286.kotlinogreniyorum.domain.model.Topic
import kotlinx.coroutines.flow.Flow

interface TopicsRepository {
    suspend fun getTopics(moduleId: Int): Flow<Resource<List<Topic>>>
}