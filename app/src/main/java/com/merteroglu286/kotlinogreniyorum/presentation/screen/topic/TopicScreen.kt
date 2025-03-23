package com.merteroglu286.kotlinogreniyorum.presentation.screen.topic

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.navigationBars
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBars
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import com.merteroglu286.kotlinogreniyorum.ui.theme.MEDIUM_PADDING
import com.merteroglu286.kotlinogreniyorum.ui.theme.screenBackgroundColor
import org.koin.androidx.compose.koinViewModel

@Composable
fun TopicScreen(
    navHostController: NavHostController,
    viewModel: TopicViewModel = koinViewModel()
) {
    val state by viewModel.topicListState.collectAsState()
    var currentStep by rememberSaveable { mutableStateOf(0) }
    var visibleContentCount by rememberSaveable { mutableStateOf(1) }
    var showExamples by rememberSaveable { mutableStateOf(false) }

    val isLastTopic = currentStep == fakeTopicList.size - 1
    val currentTopic = fakeTopicList[currentStep]

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = MaterialTheme.colorScheme.screenBackgroundColor)
            .windowInsetsPadding(WindowInsets.navigationBars)
            .windowInsetsPadding(WindowInsets.systemBars)
            .padding(MEDIUM_PADDING)
    ) {
        TopicScreenContent(
            currentTopic = currentTopic,
            currentStep = currentStep,
            totalSteps = fakeTopicList.size,
            visibleContentCount = visibleContentCount,
            showExamples = showExamples,
            isLastTopic = isLastTopic,
            onContentClick = {
                if (visibleContentCount < currentTopic.content.size) {
                    visibleContentCount++
                } else if (!showExamples) {
                    showExamples = true
                }
            },
            onResetClick = {
                currentStep = 0
                visibleContentCount = 1
                showExamples = false
            },
            onNextClick = {
                if (isLastTopic) {
                    navHostController.popBackStack()
                } else {
                    currentStep += 1
                    visibleContentCount = 1
                    showExamples = false
                }
            }
        )
    }

}









