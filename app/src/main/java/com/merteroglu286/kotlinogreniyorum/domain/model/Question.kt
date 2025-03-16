package com.merteroglu286.kotlinogreniyorum.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.merteroglu286.kotlinogreniyorum.utility.Constants.QUESTION_DATABASE_TABLE

@Entity(tableName = QUESTION_DATABASE_TABLE)
data class Question(
    @PrimaryKey(autoGenerate = false)
    val id: Int,
    val moduleId: Int,
    val questionText: String,
    val options: List<String>,
    val correctAnswerIndex: Int
)
