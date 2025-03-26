package com.merteroglu286.kotlinogreniyorum.presentation.screen.onboarding

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.navigationBars
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import com.merteroglu286.kotlinogreniyorum.domain.model.OnboardingPage
import com.merteroglu286.kotlinogreniyorum.navigation.Screen
import com.merteroglu286.kotlinogreniyorum.presentation.screen.onboarding.components.FinishButton
import com.merteroglu286.kotlinogreniyorum.presentation.screen.onboarding.components.PagerScreen
import com.merteroglu286.kotlinogreniyorum.ui.theme.EXTRA_LARGE_PADDING
import com.merteroglu286.kotlinogreniyorum.ui.theme.activeIndicatorColor
import com.merteroglu286.kotlinogreniyorum.ui.theme.inactiveIndicatorColor
import com.merteroglu286.kotlinogreniyorum.ui.theme.screenBackgroundColor
import mx.platacard.pagerindicator.PagerIndicator
import mx.platacard.pagerindicator.PagerIndicatorOrientation
import org.koin.androidx.compose.koinViewModel

@Composable
fun OnBoardingScreen(
    navHostController: NavHostController,
    viewModel: OnBoardingViewModel = koinViewModel()
) {
    val pages = listOf(
        OnboardingPage.First,
        OnboardingPage.Second,
        OnboardingPage.Third
    )

    val pagerState = rememberPagerState(pageCount = { pages.size })

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = MaterialTheme.colorScheme.screenBackgroundColor)
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
            navHostController.popBackStack()
            navHostController.navigate(Screen.Home.route)
            viewModel.saveOnBoardingState(true)
        }
    }
}