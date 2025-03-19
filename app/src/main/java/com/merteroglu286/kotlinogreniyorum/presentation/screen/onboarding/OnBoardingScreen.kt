package com.merteroglu286.kotlinogreniyorum.presentation.screen.onboarding

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.navigationBars
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import com.merteroglu286.kotlinogreniyorum.R
import com.merteroglu286.kotlinogreniyorum.domain.model.OnboardingPage
import com.merteroglu286.kotlinogreniyorum.navigation.Screen
import com.merteroglu286.kotlinogreniyorum.ui.theme.EXTRA_LARGE_PADDING
import com.merteroglu286.kotlinogreniyorum.ui.theme.LARGE_PADDING
import com.merteroglu286.kotlinogreniyorum.ui.theme.activeIndicatorColor
import com.merteroglu286.kotlinogreniyorum.ui.theme.buttonColor
import com.merteroglu286.kotlinogreniyorum.ui.theme.descriptionColor
import com.merteroglu286.kotlinogreniyorum.ui.theme.iconColor
import com.merteroglu286.kotlinogreniyorum.ui.theme.inactiveIndicatorColor
import com.merteroglu286.kotlinogreniyorum.ui.theme.titleColor
import com.merteroglu286.kotlinogreniyorum.ui.theme.onBoardingScreenBackgroundColor
import mx.platacard.pagerindicator.PagerIndicator
import mx.platacard.pagerindicator.PagerIndicatorOrientation

@Composable
fun OnBoardingScreen(navHostController: NavHostController) {
    val pages = listOf(
        OnboardingPage.First,
        OnboardingPage.Second,
        OnboardingPage.Third
    )

    val pagerState = rememberPagerState(pageCount = { pages.size })

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = onBoardingScreenBackgroundColor())
            .windowInsetsPadding(WindowInsets.navigationBars),
        verticalArrangement = Arrangement.Top
    ) {
        HorizontalPager(
            modifier = Modifier.weight(10f),
            state = pagerState,
            verticalAlignment = Alignment.CenterVertically
        ) { position ->
            PagerScreen(onboardingPage = pages[position])
        }

        PagerIndicator(
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .padding(top = EXTRA_LARGE_PADDING)
                .weight(1f),
            pagerState = pagerState,
            activeDotColor = MaterialTheme.colorScheme.activeIndicatorColor,
            dotColor = MaterialTheme.colorScheme.inactiveIndicatorColor,
            dotCount = pages.size,
            orientation = PagerIndicatorOrientation.Horizontal
        )

        FinishButton(
            modifier = Modifier.
                weight(1f),
            pagerState = pagerState
        ) {
            navHostController.navigate(Screen.Home.route)
        }
    }
}


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

@Composable
fun FinishButton(
    modifier: Modifier,
    pagerState: PagerState,
    onClick: () -> Unit
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = EXTRA_LARGE_PADDING),
        verticalAlignment = Alignment.Top,
        horizontalArrangement = Arrangement.Center
    ) {
        AnimatedVisibility(
            modifier = Modifier
                .fillMaxWidth(),
            visible = pagerState.currentPage == 2
        ) {
            Button(
                onClick = onClick,
                colors = ButtonDefaults.buttonColors(
                    containerColor = MaterialTheme.colorScheme.buttonColor,
                    contentColor = Color.White
                )
            ) {
                Text(
                    stringResource(R.string.finish)
                )
            }
        }
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
