package com.merteroglu286.kotlinogreniyorum.data.repository

import com.merteroglu286.kotlinogreniyorum.data.local.dao.TopicDao
import com.merteroglu286.kotlinogreniyorum.data.remote.ApiService
import com.merteroglu286.kotlinogreniyorum.domain.Resource
import com.merteroglu286.kotlinogreniyorum.domain.model.Topic
import com.merteroglu286.kotlinogreniyorum.domain.repository.TopicsRepository
import com.merteroglu286.kotlinogreniyorum.utility.toTopicList
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.withContext


class TopicRepositoryImpl(
    private val apiService: ApiService,
    private val topicDao: TopicDao
) : TopicsRepository {
    override suspend fun getTopics(moduleId: Int): Flow<Resource<List<Topic>>> = flow {
        emit(Resource.Loading())

        val localTopics = withContext(Dispatchers.IO) {
            topicDao.getTopicByModuleId(moduleId)
        }

        if (localTopics.isEmpty()) {
            try {
                val response = apiService.getTopics(moduleId)
                if (response.data != null) {
                    val topics = response.data.toTopicList()

                    withContext(Dispatchers.IO) {
                        topicDao.deleteTopicsByModuleId(moduleId)
                        topicDao.addTopics(topics)
                    }

                    emit(Resource.Success(topics))
                } else if (response.errorMessage != null) {
                    emit(Resource.Error(response.errorMessage))
                }
            } catch (e: Exception) {
                emit(Resource.Error(e.message ?: "Bilinmeyen hata"))
            }
        } else {
            emit(Resource.Success(localTopics))
        }
    }
}