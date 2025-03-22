package com.merteroglu286.kotlinogreniyorum.di

import com.merteroglu286.kotlinogreniyorum.data.remote.ApiService
import org.koin.dsl.module

val networkModule = module {
    single { ApiService() }
}