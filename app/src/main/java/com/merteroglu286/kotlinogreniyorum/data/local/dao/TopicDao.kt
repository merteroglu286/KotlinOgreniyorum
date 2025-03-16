package com.merteroglu286.kotlinogreniyorum.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.merteroglu286.kotlinogreniyorum.domain.model.Topic

@Dao
interface TopicDao {
    @Query("SELECT * FROM topic_table WHERE id=:moduleId")
    fun getTopicByModuleId(moduleId: Int): List<Topic>

    @Insert()
    suspend fun addTopics(topics: List<Topic>)

    @Query("DELETE FROM topic_table")
    suspend fun deleteAllTopics()
}