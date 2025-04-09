package com.merteroglu286.kotlinogreniyorum.domain.uce_cases.save_progress

import com.merteroglu286.kotlinogreniyorum.domain.repository.Repository

class SaveProgressUseCase (
    private val repository: Repository
){
    suspend operator fun invoke(progress: Float){
        repository.saveProgress(progress)
    }
}