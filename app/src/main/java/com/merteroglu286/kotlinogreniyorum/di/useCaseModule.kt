package com.merteroglu286.kotlinogreniyorum.di

import com.merteroglu286.kotlinogreniyorum.domain.uce_cases.UseCases
import com.merteroglu286.kotlinogreniyorum.domain.uce_cases.get_modules.GetModulesUseCase
import com.merteroglu286.kotlinogreniyorum.domain.uce_cases.get_topics.GetTopicsUseCase
import com.merteroglu286.kotlinogreniyorum.domain.uce_cases.read_onboarding.ReadOnBoardingUseCase
import com.merteroglu286.kotlinogreniyorum.domain.uce_cases.save_onboarding.SaveOnBoardingUseCase
import org.koin.dsl.module

val useCaseModule = module {

    single { SaveOnBoardingUseCase(get()) }
    single { ReadOnBoardingUseCase(get()) }
    single { GetModulesUseCase(get()) }
    single { GetTopicsUseCase(get()) }

    single<UseCases> {
        UseCases(
            saveOnBoardingUseCase = get(),
            readOnBoardingUseCase = get(),
            getModulesUseCase = get(),
            getTopicsUseCase = get()
        )
    }
}