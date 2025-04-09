package com.merteroglu286.kotlinogreniyorum.data.repository

import com.merteroglu286.kotlinogreniyorum.data.local.dao.ModuleDao
import com.merteroglu286.kotlinogreniyorum.data.remote.ApiService
import com.merteroglu286.kotlinogreniyorum.domain.Resource
import com.merteroglu286.kotlinogreniyorum.domain.model.Module
import com.merteroglu286.kotlinogreniyorum.domain.repository.ModuleRepository
import com.merteroglu286.kotlinogreniyorum.utility.toModuleList
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.withContext


class ModuleRepositoryImpl(
    private val apiService: ApiService,
    private val moduleDao: ModuleDao
) : ModuleRepository {
    override suspend fun getModules(): Flow<Resource<List<Module>>> = flow {
        emit(Resource.Loading())

        val localModules = withContext(Dispatchers.IO) {
            moduleDao.getAllModules()
        }

        if (localModules.isEmpty()) {
            try {
                val response = apiService.getModules()
                if (response.data != null) {
                    val modules = response.data.toModuleList()

                    withContext(Dispatchers.IO) {
                        moduleDao.deleteAllModules()
                        moduleDao.addModules(modules)
                    }

                    emit(Resource.Success(modules))
                } else if (response.errorMessage != null) {
                    emit(Resource.Error(response.errorMessage))
                }
            } catch (e: Exception) {
                emit(Resource.Error(e.message ?: "Bilinmeyen hata"))
            }
        } else {
            emit(Resource.Success(localModules))
        }

    }

    fun refreshModules(): Flow<Resource<List<Module>>> = flow {
        emit(Resource.Loading())

        try {
            val response = apiService.getModules()
            if (response.data != null) {
                val modules = response.data.toModuleList()

                withContext(Dispatchers.IO) {
                    moduleDao.deleteAllModules()
                    moduleDao.addModules(modules)
                }

                emit(Resource.Success(modules))
            } else if (response.errorMessage != null) {
                emit(Resource.Error(response.errorMessage))
            }
        } catch (e: Exception) {
            emit(Resource.Error(e.message ?: "Bilinmeyen hata"))
        }
    }
}