package com.merteroglu286.kotlinogreniyorum.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.merteroglu286.kotlinogreniyorum.utility.Constants.MODULE_DATABASE_TABLE

@Entity(tableName = MODULE_DATABASE_TABLE)
data class Module(
    @PrimaryKey(autoGenerate = false)
    val id: Int,
    val title: String,
    val description: String
)