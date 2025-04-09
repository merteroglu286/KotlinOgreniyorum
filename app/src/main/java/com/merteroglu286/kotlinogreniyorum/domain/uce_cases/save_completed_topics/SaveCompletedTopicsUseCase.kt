package com.merteroglu286.kotlinogreniyorum.domain.uce_cases.save_completed_topics

import com.merteroglu286.kotlinogreniyorum.domain.repository.Repository


class SaveCompletedTopicsUseCase(
    private val repository: Repository
) {
    suspend operator fun invoke(moduleId: Int){
        repository.saveModuleIdToListForTopic(moduleId)
    }
}