package com.merteroglu286.kotlinogreniyorum

import android.app.Application
import com.merteroglu286.kotlinogreniyorum.di.dataStoreModule
import com.merteroglu286.kotlinogreniyorum.di.databaseModule
import com.merteroglu286.kotlinogreniyorum.di.networkModule
import com.merteroglu286.kotlinogreniyorum.di.repositoryModule
import com.merteroglu286.kotlinogreniyorum.di.useCaseModule
import com.merteroglu286.kotlinogreniyorum.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class MyApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger()
            androidContext(this@MyApplication)
            modules(
                databaseModule,
                dataStoreModule,
                repositoryModule,
                useCaseModule,
                viewModelModule,
                networkModule
            )
        }
    }
}