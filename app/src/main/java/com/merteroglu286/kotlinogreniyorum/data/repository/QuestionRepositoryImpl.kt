package com.merteroglu286.kotlinogreniyorum.data.repository

import com.merteroglu286.kotlinogreniyorum.data.local.dao.QuestionDao
import com.merteroglu286.kotlinogreniyorum.data.remote.ApiService
import com.merteroglu286.kotlinogreniyorum.domain.Resource
import com.merteroglu286.kotlinogreniyorum.domain.model.Question
import com.merteroglu286.kotlinogreniyorum.domain.repository.QuestionRepository
import com.merteroglu286.kotlinogreniyorum.utility.toQuestionList
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.withContext

class QuestionRepositoryImpl(
    private val apiService: ApiService,
    private val questionDao: QuestionDao
) : QuestionRepository {
    override suspend fun getQuestions(moduleId: Int): Flow<Resource<List<Question>>> = flow {
        emit(Resource.Loading())

        val localQuestions = withContext(Dispatchers.IO) {
            questionDao.getQuestionsByModuleId(moduleId)
        }

        if (localQuestions.isEmpty()) {
            try {
                val response = apiService.getQuestions(moduleId)
                if (response.data != null) {
                    val questions = response.data.toQuestionList()

                    withContext(Dispatchers.IO) {
                        questionDao.deleteQuestionsByModuleId(moduleId)
                        questionDao.addQuestions(questions)
                    }

                    emit(Resource.Success(questions))
                } else if (response.errorMessage != null) {
                    emit(Resource.Error(response.errorMessage))
                }
            } catch (e: Exception) {
                emit(Resource.Error(e.message ?: "Bilinmeyen hata"))
            }
        } else {
            emit(Resource.Success(localQuestions))
        }
    }
}