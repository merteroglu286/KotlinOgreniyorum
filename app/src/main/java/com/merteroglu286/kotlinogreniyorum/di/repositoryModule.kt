package com.merteroglu286.kotlinogreniyorum.di

import com.merteroglu286.kotlinogreniyorum.data.repository.ModuleRepositoryImpl
import com.merteroglu286.kotlinogreniyorum.data.repository.RepositoryImpl
import com.merteroglu286.kotlinogreniyorum.data.repository.TopicRepositoryImpl
import com.merteroglu286.kotlinogreniyorum.domain.repository.ModuleRepository
import com.merteroglu286.kotlinogreniyorum.domain.repository.Repository
import com.merteroglu286.kotlinogreniyorum.domain.repository.TopicsRepository
import org.koin.dsl.module

val repositoryModule = module {

    single<Repository> {
        RepositoryImpl(get())
    }

    single <ModuleRepository> {
        ModuleRepositoryImpl(get())
    }

    single <TopicsRepository> {
        TopicRepositoryImpl(get())
    }

}