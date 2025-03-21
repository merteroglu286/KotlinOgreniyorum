package com.merteroglu286.kotlinogreniyorum.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.merteroglu286.kotlinogreniyorum.presentation.screen.splash.SplashScreen
import com.merteroglu286.kotlinogreniyorum.presentation.screen.onboarding.OnBoardingScreen

@Composable
fun SetupNavGraph(navHostController: NavHostController
) {
    NavHost(
        navController = navHostController,
        startDestination = Screen.Splash.route,
    ) {
        composable(route = Screen.Splash.route) {
            SplashScreen(navHostController)
        }
        composable(route = Screen.OnBoarding.route) {
            OnBoardingScreen(navHostController)
        }
        composable(route = Screen.Home.route) {

        }
    }
}