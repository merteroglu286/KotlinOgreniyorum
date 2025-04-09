package com.merteroglu286.kotlinogreniyorum.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.merteroglu286.kotlinogreniyorum.presentation.screen.home.HomeScreen
import com.merteroglu286.kotlinogreniyorum.presentation.screen.splash.SplashScreen
import com.merteroglu286.kotlinogreniyorum.presentation.screen.onboarding.OnBoardingScreen
import com.merteroglu286.kotlinogreniyorum.presentation.screen.question.QuestionScreen
import com.merteroglu286.kotlinogreniyorum.presentation.screen.topic.TopicScreen
import com.merteroglu286.kotlinogreniyorum.utility.Constants.QUESTION_ARGUMENT_KEY
import com.merteroglu286.kotlinogreniyorum.utility.Constants.TOPIC_ARGUMENT_KEY

@Composable
fun SetupNavGraph(
    navHostController: NavHostController
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
        composable(
            route = Screen.Topic.route,
            arguments = listOf(
                navArgument(TOPIC_ARGUMENT_KEY)
                {
                    type = NavType.IntType
                }
            )
        ) {
            TopicScreen(navHostController)
        }
        composable(
            route = Screen.Question.route,
            arguments = listOf(
                navArgument(QUESTION_ARGUMENT_KEY)
                {
                    type = NavType.IntType
                }
            )
        ) {
            QuestionScreen(navHostController)
        }
    }
}