package com.merteroglu286.kotlinogreniyorum.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.merteroglu286.kotlinogreniyorum.data.local.dao.ModuleDao
import com.merteroglu286.kotlinogreniyorum.data.local.dao.QuestionDao
import com.merteroglu286.kotlinogreniyorum.data.local.dao.TopicDao
import com.merteroglu286.kotlinogreniyorum.domain.model.Module
import com.merteroglu286.kotlinogreniyorum.domain.model.Question
import com.merteroglu286.kotlinogreniyorum.domain.model.Topic

@Database(entities = [ Module::class, Topic::class, Question::class], version = 1)
@TypeConverters(Converters::class)
abstract class AppDatabase : RoomDatabase() {
    abstract fun moduleDao(): ModuleDao
    abstract fun topicDao(): TopicDao
    abstract fun questionDao(): QuestionDao
}