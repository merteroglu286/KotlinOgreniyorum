package com.merteroglu286.kotlinogreniyorum.domain.uce_cases.get_modules

import com.merteroglu286.kotlinogreniyorum.domain.Resource
import com.merteroglu286.kotlinogreniyorum.domain.model.Module
import com.merteroglu286.kotlinogreniyorum.domain.repository.ModuleRepository
import kotlinx.coroutines.flow.Flow

class GetModulesUseCase(
    private val repository: ModuleRepository
) {
    suspend operator fun invoke(): Flow<Resource<List<Module>>> {
        return repository.getModules()
    }
}