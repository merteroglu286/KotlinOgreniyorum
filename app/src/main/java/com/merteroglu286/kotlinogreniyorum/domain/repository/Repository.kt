package com.merteroglu286.kotlinogreniyorum.domain.repository

import kotlinx.coroutines.flow.Flow

interface Repository {
    suspend fun saveOnBoardingState(isComplete: Boolean)
    fun readOnBoardingState(): Flow<Boolean>
}