package com.merteroglu286.kotlinogreniyorum.di

import androidx.room.Room
import com.merteroglu286.kotlinogreniyorum.data.local.AppDatabase
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val appModule = module {
    single {
        Room.databaseBuilder(
            androidContext(),
            AppDatabase::class.java,
            "app_database"
        )
    }
}