package com.merteroglu286.kotlinogreniyorum.presentation.screen.splash

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.tween
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.navigation.NavHostController
import com.merteroglu286.kotlinogreniyorum.navigation.Screen
import com.merteroglu286.kotlinogreniyorum.presentation.screen.splash.components.Splash
import org.koin.androidx.compose.koinViewModel

@Composable
fun SplashScreen(
    navHostController: NavHostController,
    viewModel: SplashViewModel = koinViewModel()
) {

    val onBoardingCompleted by viewModel.onBoardingCompleted.collectAsState()

    val scale = remember { Animatable(0f) }

    LaunchedEffect(key1 = true) {
        scale.animateTo(
            targetValue = 1f,
            animationSpec = tween(
                durationMillis = 1000,
                delayMillis = 200
            )
        )

        navHostController.popBackStack()

        if (onBoardingCompleted) {
            navHostController.navigate(Screen.Home.route)
        } else {
            navHostController.navigate(Screen.OnBoarding.route)
        }
    }

    Splash(scale.value)
}