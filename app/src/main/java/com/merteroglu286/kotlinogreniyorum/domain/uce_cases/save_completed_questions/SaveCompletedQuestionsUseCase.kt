package com.merteroglu286.kotlinogreniyorum.domain.uce_cases.save_completed_questions

import com.merteroglu286.kotlinogreniyorum.domain.repository.Repository

class SaveCompletedQuestionsUseCase(
    private val repository: Repository
) {
    suspend operator fun invoke(moduleId: Int){
        repository.saveModuleIdToListForQuestion(moduleId)
    }
}