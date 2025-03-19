package com.merteroglu286.kotlinogreniyorum.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.ColorScheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color

val Purple80 = Color(0xFFD0BCFF)
val PurpleGrey80 = Color(0xFFCCC2DC)
val Pink80 = Color(0xFFEFB8C8)

val Purple40 = Color(0xFF6650a4)
val PurpleGrey40 = Color(0xFF625b71)
val Pink40 = Color(0xFF7D5260)

val LightGray = Color(0xFFd9d9d9)
val Gray = Color(0xFF282828)
val DarkGreen = Color(0xFF111111)
val DeepEmerald = Color(0xFF0D3319)
val LightGreen = Color(0xFF338275)
val PastelBlue = Color(0xFFB0C4DE)
val Black = Color(0xFF000000)

@Composable
fun backgroundGradient(): Brush {
    return if (isSystemInDarkTheme()) {
        Brush.linearGradient(
            colors = listOf(Black, DarkGreen)
        )
    } else {
        Brush.verticalGradient(
            colors = listOf(LightGray, PastelBlue)
        )
    }
}

@Composable
fun onBoardingScreenBackgroundColor(): Color {
    return if (isSystemInDarkTheme()) Black else LightGray
}

val ColorScheme.titleColor: Color
    @Composable
    get() = if (isSystemInDarkTheme()) Color.White else DarkGreen

val ColorScheme.descriptionColor: Color
    @Composable
    get() = if (isSystemInDarkTheme()) LightGray else Gray

val ColorScheme.iconColor: Color
    @Composable
    get() = if (isSystemInDarkTheme()) LightGreen else DeepEmerald

val ColorScheme.activeIndicatorColor: Color
    @Composable
    get() = if (isSystemInDarkTheme()) Color.White else DarkGreen

val ColorScheme.inactiveIndicatorColor: Color
    @Composable
    get() = if (isSystemInDarkTheme()) Color.LightGray else Gray

val ColorScheme.buttonColor: Color
    @Composable
    get() = if (isSystemInDarkTheme()) LightGreen else DeepEmerald