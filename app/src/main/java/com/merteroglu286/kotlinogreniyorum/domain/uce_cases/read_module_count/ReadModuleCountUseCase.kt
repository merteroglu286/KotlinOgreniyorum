package com.merteroglu286.kotlinogreniyorum.domain.uce_cases.read_module_count

import com.merteroglu286.kotlinogreniyorum.domain.repository.Repository
import kotlinx.coroutines.flow.Flow

class ReadModuleCountUseCase(
    private val repository: Repository
) {
    operator fun invoke(): Flow<Int> {
        return repository.readModuleCount()
    }
}