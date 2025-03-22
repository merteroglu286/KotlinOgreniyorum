package com.merteroglu286.kotlinogreniyorum.data.remote.dto

import kotlinx.serialization.Serializable

@Serializable
data class TopicDto(
    val id: Int? = null,
    val title: String,
    val moduleId: Int? = null,
    val content: List<String>,
    val examples: List<String> = emptyList()
)