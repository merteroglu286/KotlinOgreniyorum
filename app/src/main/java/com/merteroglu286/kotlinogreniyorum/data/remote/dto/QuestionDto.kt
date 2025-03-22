package com.merteroglu286.kotlinogreniyorum.data.remote.dto

import kotlinx.serialization.Serializable

@Serializable
data class QuestionDto(
    val id: Int,
    val moduleId: Int,
    val questionText: String,
    val options: List<String>,
    val correctAnswerIndex: Int
)
