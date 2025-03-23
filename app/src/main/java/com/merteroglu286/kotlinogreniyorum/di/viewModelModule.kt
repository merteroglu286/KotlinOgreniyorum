package com.merteroglu286.kotlinogreniyorum.di


import com.merteroglu286.kotlinogreniyorum.presentation.screen.home.HomeViewModel
import com.merteroglu286.kotlinogreniyorum.presentation.screen.onboarding.OnBoardingViewModel
import com.merteroglu286.kotlinogreniyorum.presentation.screen.splash.SplashViewModel
import com.merteroglu286.kotlinogreniyorum.presentation.screen.topic.TopicViewModel
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {

    viewModel { SplashViewModel(get()) }
    viewModel { OnBoardingViewModel(get()) }
    viewModel { HomeViewModel(get()) }
    viewModel { TopicViewModel(get()) }
}