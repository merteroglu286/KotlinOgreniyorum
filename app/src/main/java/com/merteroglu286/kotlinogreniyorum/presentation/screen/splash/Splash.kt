package com.merteroglu286.kotlinogreniyorum.presentation.screen.splash

import android.content.res.Configuration
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import com.merteroglu286.kotlinogreniyorum.R
import com.merteroglu286.kotlinogreniyorum.ui.theme.SplashBackgroundColor
import com.merteroglu286.kotlinogreniyorum.ui.theme.SplashTextColor

@Composable
fun Splash(scale: Float) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(brush = MaterialTheme.colorScheme.SplashBackgroundColor),
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
                text = stringResource(R.string.app_name),
                modifier = Modifier.align(Alignment.CenterHorizontally),
                textAlign = TextAlign.Center,
                color = MaterialTheme.colorScheme.SplashTextColor,
                style = MaterialTheme.typography.titleMedium
            )
        }
    }
}

@Preview()
@Composable
fun SplashScreenPreview() {
    Splash(scale = 1f)

}

@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun SplashScreenDarkPreview() {
    Splash(scale = 1f)
}