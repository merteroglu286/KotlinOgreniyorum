package com.merteroglu286.kotlinogreniyorum.data.remote.dto

import kotlinx.serialization.Serializable

@Serializable
data class ApiResponse<T>(
    val data: T? = null,
    val errorMessage: String? = null
)