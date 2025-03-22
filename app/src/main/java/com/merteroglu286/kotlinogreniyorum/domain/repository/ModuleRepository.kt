package com.merteroglu286.kotlinogreniyorum.domain.repository

import com.merteroglu286.kotlinogreniyorum.domain.Resource
import com.merteroglu286.kotlinogreniyorum.domain.model.Module
import kotlinx.coroutines.flow.Flow

interface ModuleRepository {
    suspend fun getModules(): Flow<Resource<List<Module>>>
}