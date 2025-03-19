package com.merteroglu286.kotlinogreniyorum.navigation

sealed class Screen(val route: String) {
    data object Splash : Screen("splash_screen")
    data object OnBoarding : Screen("on_boarding_screen")
    data object Home : Screen("home_screen")
}