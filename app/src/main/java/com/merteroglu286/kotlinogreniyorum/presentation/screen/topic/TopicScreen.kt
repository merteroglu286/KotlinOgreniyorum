package com.merteroglu286.kotlinogreniyorum.presentation.screen.topic

import android.util.Log
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
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavHostController
import com.merteroglu286.kotlinogreniyorum.R
import com.merteroglu286.kotlinogreniyorum.presentation.components.CircularProgress
import com.merteroglu286.kotlinogreniyorum.presentation.components.ErrorDialog
import com.merteroglu286.kotlinogreniyorum.presentation.components.SuccessDialog
import com.merteroglu286.kotlinogreniyorum.presentation.screen.topic.components.TopicScreenContent
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
    var showSuccessDialog by rememberSaveable { mutableStateOf(false) }

    when {
        state.isLoading -> {
            CircularProgress()
        }
        state.topics.isNotEmpty() -> {
            val isLastTopic = currentStep == state.topics.size - 1
            val currentTopic = state.topics[currentStep]

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
                    totalSteps = state.topics.size,
                    visibleContentCount = visibleContentCount,
                    showExamples = showExamples,
                    isLastTopic = isLastTopic,
                    isFirsTopic = currentStep == 0,
                    onBackClick = {
                        navHostController.popBackStack()
                    },
                    onContentClick = {
                        if (visibleContentCount < currentTopic.content.size) {
                            visibleContentCount++
                        }
                        else if (!showExamples) {
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
                            showSuccessDialog = true
                        } else {
                            currentStep += 1
                            visibleContentCount = 1
                            showExamples = false
                        }
                    }
                )
            }

            if (showSuccessDialog){
                SuccessDialog(
                    onDismissRequest = {},
                    onConfirm = {
                        showSuccessDialog = false
                        viewModel.saveTopics()
                        navHostController.popBackStack()
                    },
                    title = stringResource(R.string.congratulations),
                    message = stringResource(R.string.you_have_completed_all_modules)
                )
            }
        }

        state.error.isNotEmpty() -> {
            Log.d("mertLog","burasi çalisti 2")
            ErrorDialog(
                onDismissRequest = {},
                onConfirm = {
                    navHostController.popBackStack()
                },
                message = state.error,
                buttonText = stringResource(R.string.turn_back)
            )
        }

        else -> {
            ErrorDialog(
                onDismissRequest = {},
                onConfirm = {
                    navHostController.popBackStack()
                },
                message = "Konular bulunamadı",
                buttonText = stringResource(R.string.turn_back)
            )
        }
    }
}