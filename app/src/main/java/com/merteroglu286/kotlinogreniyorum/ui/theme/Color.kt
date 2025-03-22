package com.merteroglu286.kotlinogreniyorum.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.ColorScheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color

val DeepMidnight = Color(0xFF040D12)
val TealForest = Color(0xFF183D3D)
val MutedJade = Color(0xFF5C8374)
val SoftSage = Color(0xFF93B1A6)

val IvoryWhite = Color(0xFFF8F9F6)
val PaleSage = Color(0xFFE3EAE5)
val MintGreen = Color(0xFFBFD1C9)
val SilverGreen = Color(0xFF7A9389)

val DarkPaleSage = Color(0xFFC5CDC8)
val DarkMintGreen = Color(0xFFA1B5AD)
val DarkSilverGreen = Color(0xFF5E7A6F)

val PrimaryGray = Color(0xFF757575)
val LightGray = Color(0xFFE0E0E0)
val DarkGray = Color(0xFF424242)

val Black = Color(0xFF000000)
val White = Color(0xFFFFFFFF)

val Brown = Color(0xFF8B5A2B)

val Orange = Color(0xFFFFAB00)


val ColorScheme.screenBackgroundColor: Color
    @Composable
    get() = if (isSystemInDarkTheme()) DeepMidnight else IvoryWhite

val ColorScheme.SplashBackgroundColor: Brush
    @Composable
    get() = if (isSystemInDarkTheme()) Brush.verticalGradient(
        colors = listOf(DeepMidnight, TealForest)
    ) else Brush.verticalGradient(
        colors = listOf(IvoryWhite, PaleSage)
    )

val ColorScheme.SplashTextColor: Color
    @Composable
    get() = if (isSystemInDarkTheme()) IvoryWhite else DeepMidnight


val ColorScheme.activeIndicatorColor: Color
    @Composable
    get() = if (isSystemInDarkTheme()) MutedJade else SoftSage

val ColorScheme.inactiveIndicatorColor: Color
    @Composable
    get() = if (isSystemInDarkTheme()) TealForest else PaleSage

val ColorScheme.buttonColor: Color
    @Composable
    get() = if (isSystemInDarkTheme()) TealForest else DarkSilverGreen

val ColorScheme.buttonTextColor: Color
    get() = IvoryWhite

val ColorScheme.titleColor: Color
    @Composable
    get() = if (isSystemInDarkTheme()) IvoryWhite else DeepMidnight

val ColorScheme.descriptionColor: Color
    @Composable
    get() = if (isSystemInDarkTheme()) SoftSage else DarkSilverGreen

val ColorScheme.iconColor: Color
    @Composable
    get() = if (isSystemInDarkTheme()) SoftSage else TealForest

val ColorScheme.cardBackgroundColor: Color
    @Composable
    get() = if (isSystemInDarkTheme()) TealForest else DarkMintGreen

val ColorScheme.expandedCardBackgroundColor: Color
    @Composable
    get() = if (isSystemInDarkTheme()) Black.copy(alpha = 0.5f) else White.copy(alpha = 0.6f) // Kontrast için küçük bir değişiklik

val ColorScheme.HeaderTitleColor: Color
    @Composable
    get() = if (isSystemInDarkTheme()) Orange else Brown

val ColorScheme.ProgressIndicatorColor: Color
    @Composable
    get() = if (isSystemInDarkTheme()) Orange else Brown

val ColorScheme.ProgressIndicatorTrackColor: Color
    @Composable
    get() = if (isSystemInDarkTheme()) Orange.copy(0.7f) else Brown.copy(0.7f)

val ColorScheme.defaultTextColor: Color
    @Composable
    get() = if (isSystemInDarkTheme()) White else Black

val ColorScheme.DividerColor: Color
    @Composable
    get() = if (isSystemInDarkTheme()) DarkGray else LightGray