package com.merteroglu286.kotlinogreniyorum.data.repository

import com.merteroglu286.kotlinogreniyorum.domain.preferences.DataStoreOperations
import com.merteroglu286.kotlinogreniyorum.domain.repository.Repository
import kotlinx.coroutines.flow.Flow

class RepositoryImpl(
    private val dataStore: DataStoreOperations
): Repository {
    override suspend fun saveOnBoardingState(isComplete: Boolean) {
        dataStore.saveOnBoardingState(isComplete)
    }

    override fun readOnBoardingState(): Flow<Boolean> {
        return dataStore.readOnBoardingState()
    }

    override suspend fun saveModuleCount(count: Int) {
        dataStore.saveModuleCount(count)
    }

    override fun readModuleCount(): Flow<Int> {
        return dataStore.readModuleCount()
    }

    override suspend fun saveProgress(progress: Float) {
        dataStore.saveProgress(progress)
    }

    override fun readProgress(): Flow<Float> {
        return dataStore.readProgress()
    }

    override suspend fun saveModuleIdToListForTopic(moduleId: Int) {
        dataStore.saveModuleIdToListForTopic(moduleId)
    }

    override fun readModuleIdListForTopic(): Flow<List<Int>> {
        return dataStore.readModuleIdListForTopic()
    }

    override suspend fun saveModuleIdToListForQuestion(moduleId: Int) {
        dataStore.saveModuleIdToListForQuestion(moduleId)
    }

    override fun readModuleIdListForQuestion(): Flow<List<Int>> {
        return dataStore.readModuleIdListForQuestion()
    }

}