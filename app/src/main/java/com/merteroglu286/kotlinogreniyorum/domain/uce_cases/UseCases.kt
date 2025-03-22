package com.merteroglu286.kotlinogreniyorum.domain.uce_cases

import com.merteroglu286.kotlinogreniyorum.domain.uce_cases.get_modules.GetModulesUseCase
import com.merteroglu286.kotlinogreniyorum.domain.uce_cases.get_topics.GetTopicsUseCase
import com.merteroglu286.kotlinogreniyorum.domain.uce_cases.read_onboarding.ReadOnBoardingUseCase
import com.merteroglu286.kotlinogreniyorum.domain.uce_cases.save_onboarding.SaveOnBoardingUseCase

data class UseCases(
    val saveOnBoardingUseCase: SaveOnBoardingUseCase,
    val readOnBoardingUseCase: ReadOnBoardingUseCase,
    val getModulesUseCase: GetModulesUseCase,
    val getTopicsUseCase: GetTopicsUseCase
)