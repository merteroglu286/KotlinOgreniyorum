package com.merteroglu286.kotlinogreniyorum.di

import com.merteroglu286.kotlinogreniyorum.domain.uce_cases.UseCases
import com.merteroglu286.kotlinogreniyorum.domain.uce_cases.get_modules.GetModulesUseCase
import com.merteroglu286.kotlinogreniyorum.domain.uce_cases.get_questions.GetQuestionsUseCase
import com.merteroglu286.kotlinogreniyorum.domain.uce_cases.get_topics.GetTopicsUseCase
import com.merteroglu286.kotlinogreniyorum.domain.uce_cases.read_completed_questions.ReadCompletedQuestionsUseCase
import com.merteroglu286.kotlinogreniyorum.domain.uce_cases.read_completed_topics.ReadCompletedTopicsUseCase
import com.merteroglu286.kotlinogreniyorum.domain.uce_cases.read_module_count.ReadModuleCountUseCase
import com.merteroglu286.kotlinogreniyorum.domain.uce_cases.read_onboarding.ReadOnBoardingUseCase
import com.merteroglu286.kotlinogreniyorum.domain.uce_cases.read_progress.ReadProgressUseCase
import com.merteroglu286.kotlinogreniyorum.domain.uce_cases.save_completed_questions.SaveCompletedQuestionsUseCase
import com.merteroglu286.kotlinogreniyorum.domain.uce_cases.save_module_count.SaveModuleCountUseCase
import com.merteroglu286.kotlinogreniyorum.domain.uce_cases.save_onboarding.SaveOnBoardingUseCase
import com.merteroglu286.kotlinogreniyorum.domain.uce_cases.save_progress.SaveProgressUseCase
import com.merteroglu286.kotlinogreniyorum.domain.uce_cases.save_completed_topics.SaveCompletedTopicsUseCase
import org.koin.dsl.module

val useCaseModule = module {

    single { SaveOnBoardingUseCase(get()) }
    single { ReadOnBoardingUseCase(get()) }
    single { GetModulesUseCase(get()) }
    single { GetTopicsUseCase(get()) }
    single { GetQuestionsUseCase(get()) }
    single { SaveModuleCountUseCase(get()) }
    single { ReadModuleCountUseCase(get()) }
    single { SaveCompletedTopicsUseCase(get()) }
    single { ReadCompletedTopicsUseCase(get()) }
    single { SaveCompletedQuestionsUseCase(get()) }
    single { ReadCompletedQuestionsUseCase(get()) }
    single { SaveProgressUseCase(get()) }
    single { ReadProgressUseCase(get()) }



    single<UseCases> {
        UseCases(
            saveOnBoardingUseCase = get(),
            readOnBoardingUseCase = get(),
            getModulesUseCase = get(),
            getTopicsUseCase = get(),
            getQuestionsUseCase = get(),
            saveModuleCountUseCase = get(),
            readModuleCountUseCase = get(),
            saveCompletedTopicsUseCase = get(),
            readCompletedTopicsUseCase = get(),
            saveCompletedQuestionsUseCase = get(),
            readCompletedQuestionsUseCase = get(),
            saveProgressUseCase = get(),
            readProgressUseCase = get()
        )
    }
}