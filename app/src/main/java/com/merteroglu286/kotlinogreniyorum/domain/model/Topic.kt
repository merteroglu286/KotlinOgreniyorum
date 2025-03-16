package com.merteroglu286.kotlinogreniyorum.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.merteroglu286.kotlinogreniyorum.utility.Constants.TOPIC_DATABASE_TABLE

@Entity(tableName = TOPIC_DATABASE_TABLE)
data class Topic(
    @PrimaryKey(autoGenerate = false)
    val id: Int? = null,
    val title: String,
    val moduleId: Int? = null,
    val content: List<String>,
    val examples: List<String> = emptyList()
)
