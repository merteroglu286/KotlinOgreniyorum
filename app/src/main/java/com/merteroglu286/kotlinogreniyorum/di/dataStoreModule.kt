package com.merteroglu286.kotlinogreniyorum.di

import com.merteroglu286.kotlinogreniyorum.data.preferences.DataStoreOperationsImpl
import com.merteroglu286.kotlinogreniyorum.domain.preferences.DataStoreOperations
import org.koin.dsl.module

val dataStoreModule = module {

    single<DataStoreOperations> {
        DataStoreOperationsImpl(get())
    }

}