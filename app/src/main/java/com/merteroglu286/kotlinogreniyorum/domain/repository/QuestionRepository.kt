package com.merteroglu286.kotlinogreniyorum.domain.repository

import com.merteroglu286.kotlinogreniyorum.domain.Resource
import com.merteroglu286.kotlinogreniyorum.domain.model.Question
import kotlinx.coroutines.flow.Flow

interface QuestionRepository {
    suspend fun getQuestions(moduleId: Int): Flow<Resource<List<Question>>>
}