package com.merteroglu286.kotlinogreniyorum.presentation.screen.onboarding

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import com.merteroglu286.kotlinogreniyorum.R
import com.merteroglu286.kotlinogreniyorum.domain.model.OnboardingPage
import com.merteroglu286.kotlinogreniyorum.ui.theme.EXTRA_LARGE_PADDING
import com.merteroglu286.kotlinogreniyorum.ui.theme.LARGE_PADDING
import com.merteroglu286.kotlinogreniyorum.ui.theme.descriptionColor
import com.merteroglu286.kotlinogreniyorum.ui.theme.iconColor
import com.merteroglu286.kotlinogreniyorum.ui.theme.titleColor

@Composable
fun PagerScreen(onboardingPage: OnboardingPage) {

    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top
    ) {

        Image(
            painter = painterResource(id = onboardingPage.image),
            contentDescription = stringResource(R.string.on_boarding_image),
            modifier = Modifier
                .fillMaxWidth(0.5f)
                .fillMaxHeight(0.6f),
            colorFilter = ColorFilter.tint(color = MaterialTheme.colorScheme.iconColor)
        )

        Text(
            text = onboardingPage.title,
            color = MaterialTheme.colorScheme.titleColor,
            style = MaterialTheme.typography.titleLarge,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = LARGE_PADDING)
        )
        Text(
            text = onboardingPage.description,
            color = MaterialTheme.colorScheme.descriptionColor,
            style = MaterialTheme.typography.titleSmall,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = EXTRA_LARGE_PADDING)
                .padding(
                    top = LARGE_PADDING
                )
        )
    }
}

@Preview(showBackground = true)
@Composable
fun FirstPagerScreenPreview() {
    PagerScreen(onboardingPage = OnboardingPage.First)
}

@Preview(showBackground = true)
@Composable
fun SecondPagerScreenPreview() {
    PagerScreen(onboardingPage = OnboardingPage.Second)
}

@Preview(showBackground = true)
@Composable
fun ThirdPagerScreenPreview() {
    PagerScreen(onboardingPage = OnboardingPage.Third)
}
