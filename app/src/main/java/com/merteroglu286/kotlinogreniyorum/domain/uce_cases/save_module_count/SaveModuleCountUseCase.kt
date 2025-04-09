package com.merteroglu286.kotlinogreniyorum.domain.uce_cases.save_module_count

import com.merteroglu286.kotlinogreniyorum.domain.repository.Repository

class SaveModuleCountUseCase(
    private val repository: Repository
) {
    suspend operator fun invoke(count: Int){
        repository.saveModuleCount(count = count)
    }
}
