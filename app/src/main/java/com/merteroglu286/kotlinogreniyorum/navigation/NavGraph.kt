package com.merteroglu286.kotlinogreniyorum.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.merteroglu286.kotlinogreniyorum.presentation.screen.home.HomeScreen
import com.merteroglu286.kotlinogreniyorum.presentation.screen.splash.SplashScreen
import com.merteroglu286.kotlinogreniyorum.presentation.screen.onboarding.OnBoardingScreen
import com.merteroglu286.kotlinogreniyorum.presentation.screen.topic.TopicScreen

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
            HomeScreen(navHostController)
        }
        composable(route = Screen.Topic.route) {
            TopicScreen(navHostController)
        }
    }
}