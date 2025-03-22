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
}