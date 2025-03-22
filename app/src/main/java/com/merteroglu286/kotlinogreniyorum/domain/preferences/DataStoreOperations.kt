package com.merteroglu286.kotlinogreniyorum.domain.preferences

import kotlinx.coroutines.flow.Flow

interface DataStoreOperations{
    suspend fun saveOnBoardingState(isComplete: Boolean)
    fun readOnBoardingState(): Flow<Boolean>
}