package com.merteroglu286.kotlinogreniyorum.domain.uce_cases

import com.merteroglu286.kotlinogreniyorum.domain.uce_cases.get_modules.GetModulesUseCase
import com.merteroglu286.kotlinogreniyorum.domain.uce_cases.get_questions.GetQuestionsUseCase
import com.merteroglu286.kotlinogreniyorum.domain.uce_cases.get_topics.GetTopicsUseCase
import com.merteroglu286.kotlinogreniyorum.domain.uce_cases.read_completed_questions.ReadCompletedQuestionsUseCase
import com.merteroglu286.kotlinogreniyorum.domain.uce_cases.read_completed_topics.ReadCompletedTopicsUseCase
import com.merteroglu286.kotlinogreniyorum.domain.uce_cases.read_module_count.ReadModuleCountUseCase
import com.merteroglu286.kotlinogreniyorum.domain.uce_cases.read_onboarding.ReadOnBoardingUseCase
import com.merteroglu286.kotlinogreniyorum.domain.uce_cases.read_progress.ReadProgressUseCase
import com.merteroglu286.kotlinogreniyorum.domain.uce_cases.save_completed_questions.SaveCompletedQuestionsUseCase
import com.merteroglu286.kotlinogreniyorum.domain.uce_cases.save_completed_topics.SaveCompletedTopicsUseCase
import com.merteroglu286.kotlinogreniyorum.domain.uce_cases.save_module_count.SaveModuleCountUseCase
import com.merteroglu286.kotlinogreniyorum.domain.uce_cases.save_onboarding.SaveOnBoardingUseCase
import com.merteroglu286.kotlinogreniyorum.domain.uce_cases.save_progress.SaveProgressUseCase

data class UseCases(
    val saveOnBoardingUseCase: SaveOnBoardingUseCase,
    val readOnBoardingUseCase: ReadOnBoardingUseCase,

    val getModulesUseCase: GetModulesUseCase,
    val getTopicsUseCase: GetTopicsUseCase,
    val getQuestionsUseCase: GetQuestionsUseCase,

    val saveModuleCountUseCase: SaveModuleCountUseCase,
    val readModuleCountUseCase: ReadModuleCountUseCase,

    val saveCompletedTopicsUseCase: SaveCompletedTopicsUseCase,
    val readCompletedTopicsUseCase: ReadCompletedTopicsUseCase,

    val saveCompletedQuestionsUseCase: SaveCompletedQuestionsUseCase,
    val readCompletedQuestionsUseCase: ReadCompletedQuestionsUseCase,

    val saveProgressUseCase: SaveProgressUseCase,
    val readProgressUseCase: ReadProgressUseCase

)