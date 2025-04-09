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

val LightGray = Color(0xFF969696)
val DarkGray = Color(0xFF424242)

val PrimaryGray = Color(0xFF424242)
val SecondaryGray = Color(0xFF646464)
val PrimaryLightGray = Color(0xFFB4B4B4)
val SecondaryLightGray = Color(0xFFA0A0A0)

val Black = Color(0xFF000000)
val White = Color(0xFFFFFFFF)

val Brown = Color(0xFF8B5A2B)

val Orange = Color(0xFFFFAB00)

val Red = Color(0xFFE91E1E)
val Green = Color(0xFF4CAF50)


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
    get() = if (isSystemInDarkTheme()) MintGreen else DeepMidnight


val ColorScheme.activeIndicatorColor: Color
    @Composable
    get() = if (isSystemInDarkTheme()) MutedJade else SoftSage

val ColorScheme.inactiveIndicatorColor: Color
    @Composable
    get() = if (isSystemInDarkTheme()) TealForest else PaleSage

val ColorScheme.buttonColor: Color
    @Composable
    get() = if (isSystemInDarkTheme()) TealForest else DarkSilverGreen

val ColorScheme.outlinedButtonColor: Color
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
    get() = if (isSystemInDarkTheme()) Black.copy(alpha = 0.5f) else White.copy(alpha = 0.6f)

val ColorScheme.HeaderTitleColor: Color
    @Composable
    get() = if (isSystemInDarkTheme()) Orange else Brown

val ColorScheme.ProgressIndicatorColor: Color
    @Composable
    get() = if (isSystemInDarkTheme()) Orange else Brown

val ColorScheme.ProgressIndicatorTrackColor: Color
    @Composable
    get() = if (isSystemInDarkTheme()) Orange.copy(0.7f) else Brown.copy(0.7f)

val ColorScheme.primaryTextColor: Color
    @Composable
    get() = if (isSystemInDarkTheme()) White else Black

val ColorScheme.secondTextColor: Color
    @Composable
    get() = if (isSystemInDarkTheme()) PrimaryLightGray else PrimaryGray

val ColorScheme.thirdTextColor: Color
    @Composable
    get() = if (isSystemInDarkTheme()) SecondaryLightGray else SecondaryGray

val ColorScheme.DividerColor: Color
    @Composable
    get() = if (isSystemInDarkTheme()) DarkGray else LightGray

val ColorScheme.ActiveSegmentedIndicatorColor: Color
    @Composable
    get() = if (isSystemInDarkTheme()) Orange else Brown

val ColorScheme.InactiveSegmentedIndicatorColor: Color
    @Composable
    get() = if (isSystemInDarkTheme()) Orange.copy(0.3f) else Brown.copy(0.3f)

val ColorScheme.syntaxHighlighterColor: Color
    @Composable
    get() = if (isSystemInDarkTheme()) Color(0xFFFF9800) else Color(0xFF3F51B5)

val ColorScheme.correctAnswerColor: Color
    @Composable
    get() = if (isSystemInDarkTheme()) Green.copy(0.3f) else Green.copy(0.7f)

val ColorScheme.wrongAnswerColor: Color
    @Composable
    get() = if (isSystemInDarkTheme()) Red.copy(0.3f) else Red.copy(0.7f)

val ColorScheme.circularProgressColor: Color
    @Composable
    get() = if (isSystemInDarkTheme()) MintGreen else DeepMidnight

val ColorScheme.circularProgressBackgroundColor: Color
    @Composable
    get() = if (isSystemInDarkTheme()) White.copy(0.5f) else Black.copy(0.5f)