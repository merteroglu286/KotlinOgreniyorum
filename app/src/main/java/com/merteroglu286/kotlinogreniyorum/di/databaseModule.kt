package com.merteroglu286.kotlinogreniyorum.di

import androidx.room.Room
import com.merteroglu286.kotlinogreniyorum.data.local.AppDatabase
import com.merteroglu286.kotlinogreniyorum.utility.Constants.APP_DATABASE
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val databaseModule = module {
    single {
        Room.databaseBuilder(
            androidContext(),
            AppDatabase::class.java,
            APP_DATABASE
        )
            .fallbackToDestructiveMigration() // Geçici çözüm olarak, migration stratejisi
            .build()
    }

    single {
        get<AppDatabase>().moduleDao()
    }

    single {
        get<AppDatabase>().topicDao()
    }

    single {
        get<AppDatabase>().questionDao()
    }

}