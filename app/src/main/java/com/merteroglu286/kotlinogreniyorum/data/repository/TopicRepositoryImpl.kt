package com.merteroglu286.kotlinogreniyorum.data.repository

import com.merteroglu286.kotlinogreniyorum.data.remote.ApiService
import com.merteroglu286.kotlinogreniyorum.domain.Resource
import com.merteroglu286.kotlinogreniyorum.domain.model.Topic
import com.merteroglu286.kotlinogreniyorum.domain.repository.TopicsRepository
import com.merteroglu286.kotlinogreniyorum.utility.toTopicList
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow


class TopicRepositoryImpl(private val apiService: ApiService) : TopicsRepository {
    override suspend fun getTopics(moduleId: Int): Flow<Resource<List<Topic>>> = flow {
        emit(Resource.Loading())
        try {
            val response = apiService.getTopics(moduleId)
            if (response.data != null) {
                val modules = response.data.toTopicList()
                emit(Resource.Success(modules))
            } else if (response.errorMessage != null) {
                emit(Resource.Error(response.errorMessage))
            }
        } catch (e: Exception) {
            emit(Resource.Error(e.message ?: "Bilinmeyen hata"))
        }
    }
}