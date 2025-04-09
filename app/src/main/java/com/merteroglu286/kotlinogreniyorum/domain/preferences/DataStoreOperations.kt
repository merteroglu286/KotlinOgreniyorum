package com.merteroglu286.kotlinogreniyorum.domain.preferences

import kotlinx.coroutines.flow.Flow

interface DataStoreOperations{
    suspend fun saveOnBoardingState(isComplete: Boolean)
    fun readOnBoardingState(): Flow<Boolean>

    suspend fun saveModuleCount(count: Int)
    fun readModuleCount(): Flow<Int>

    suspend fun saveProgress(progress: Float)
    fun readProgress(): Flow<Float>

    suspend fun saveModuleIdToListForTopic(moduleId: Int)
    fun readModuleIdListForTopic(): Flow<List<Int>>

    suspend fun saveModuleIdToListForQuestion(moduleId: Int)
    fun readModuleIdListForQuestion(): Flow<List<Int>>

}