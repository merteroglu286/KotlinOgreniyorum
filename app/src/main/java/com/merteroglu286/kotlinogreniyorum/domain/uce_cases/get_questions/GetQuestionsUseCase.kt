package com.merteroglu286.kotlinogreniyorum.domain.uce_cases.get_questions

import com.merteroglu286.kotlinogreniyorum.domain.Resource
import com.merteroglu286.kotlinogreniyorum.domain.model.Question
import com.merteroglu286.kotlinogreniyorum.domain.repository.QuestionRepository
import kotlinx.coroutines.flow.Flow

class GetQuestionsUseCase(
    private val repository: QuestionRepository
) {
    suspend operator fun invoke(moduleId: Int): Flow<Resource<List<Question>>> {
        return repository.getQuestions(moduleId)
    }
}