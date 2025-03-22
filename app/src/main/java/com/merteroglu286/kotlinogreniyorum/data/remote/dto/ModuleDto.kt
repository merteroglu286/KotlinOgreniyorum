package com.merteroglu286.kotlinogreniyorum.data.remote.dto

import kotlinx.serialization.Serializable

@Serializable
data class ModuleDto(
    val id: Int,
    val title: String,
    val description: String
)