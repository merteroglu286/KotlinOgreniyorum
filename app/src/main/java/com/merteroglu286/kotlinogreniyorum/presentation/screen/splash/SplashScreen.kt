package com.merteroglu286.kotlinogreniyorum.presentation.screen.splash

import android.content.res.Configuration
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.merteroglu286.kotlinogreniyorum.R
import com.merteroglu286.kotlinogreniyorum.navigation.Screen
import com.merteroglu286.kotlinogreniyorum.ui.theme.backgroundGradient
import com.merteroglu286.kotlinogreniyorum.ui.theme.titleColor
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(navHostController: NavHostController) {

    val scale = remember { Animatable(0f) }

    LaunchedEffect(key1 = true) {
        scale.animateTo(
            targetValue = 1f, // Final scale
            animationSpec = tween(
                durationMillis = 1000,
                delayMillis = 200
            )
        )

        delay(300)
        navHostController.navigate(Screen.OnBoarding.route)
    }

    Splash(scale.value)
}

@Composable
fun Splash(scale: Float) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .border(width = 1.dp, color = Color.Black)
            .background(brush = backgroundGradient()),
        contentAlignment = Alignment.Center
    ) {
        Column(
            modifier = Modifier.scale(scale)
        ) {
            Image(
                painter = painterResource(id = R.drawable.logo),
                contentDescription = "Logo",
                modifier = Modifier.wrapContentSize()
            )
            Text(
                text = "Kotlin Öğreniyorum",
                modifier = Modifier.align(Alignment.CenterHorizontally),
                textAlign = TextAlign.Center,
                color = MaterialTheme.colorScheme.titleColor,
                style = MaterialTheme.typography.titleMedium
            )
        }
    }}

@Preview()
@Composable
fun SplashScreenPreview() {
    Splash(scale = 0f)

}

@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun SplashScreenDarkPreview() {
    Splash(scale = 0f)
}