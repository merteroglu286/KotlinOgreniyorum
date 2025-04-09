package com.merteroglu286.kotlinogreniyorum.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.merteroglu286.kotlinogreniyorum.domain.model.Question

@Dao
interface QuestionDao {
    @Query("SELECT * FROM question_table WHERE moduleId=:moduleId")
    suspend fun getQuestionsByModuleId(moduleId: Int): List<Question>

    @Insert()
    suspend fun addQuestions(questions: List<Question>)

    @Query("DELETE FROM question_table WHERE moduleId=:moduleId")
    suspend fun deleteQuestionsByModuleId(moduleId: Int)
}