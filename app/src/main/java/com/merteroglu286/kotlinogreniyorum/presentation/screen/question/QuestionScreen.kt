package com.merteroglu286.kotlinogreniyorum.presentation.screen.question

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBars
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBars
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavHostController
import com.merteroglu286.kotlinogreniyorum.R
import com.merteroglu286.kotlinogreniyorum.presentation.components.Button
import com.merteroglu286.kotlinogreniyorum.presentation.components.CircularProgress
import com.merteroglu286.kotlinogreniyorum.presentation.components.ErrorDialog
import com.merteroglu286.kotlinogreniyorum.presentation.screen.question.components.BottomSheet
import com.merteroglu286.kotlinogreniyorum.presentation.screen.question.components.Options
import com.merteroglu286.kotlinogreniyorum.presentation.components.SegmentedIndicator
import com.merteroglu286.kotlinogreniyorum.presentation.components.SuccessDialog
import com.merteroglu286.kotlinogreniyorum.ui.theme.LARGE_HEIGHT
import com.merteroglu286.kotlinogreniyorum.ui.theme.MEDIUM_HEIGHT
import com.merteroglu286.kotlinogreniyorum.ui.theme.MEDIUM_PADDING
import com.merteroglu286.kotlinogreniyorum.ui.theme.SMALL_HEIGHT
import com.merteroglu286.kotlinogreniyorum.ui.theme.SMALL_PADDING
import com.merteroglu286.kotlinogreniyorum.ui.theme.iconColor
import com.merteroglu286.kotlinogreniyorum.ui.theme.primaryTextColor
import com.merteroglu286.kotlinogreniyorum.ui.theme.screenBackgroundColor
import org.koin.androidx.compose.koinViewModel

@Composable
fun QuestionScreen(
    navHostController: NavHostController,
    viewModel: QuestionViewModel = koinViewModel()
) {
    val state by viewModel.questionListState.collectAsState()

    var currentStep by rememberSaveable { mutableIntStateOf(0) }
    var selectedOptionIndex by rememberSaveable { mutableIntStateOf(-1) }
    var wrongSelectedIndices by rememberSaveable { mutableStateOf(setOf<Int>()) }
    var showBottomSheet by rememberSaveable { mutableStateOf(false) }
    var showNextButton by rememberSaveable { mutableStateOf(false) }
    var showSuccessDialog by rememberSaveable { mutableStateOf(false) }

    when {
        state.isLoading -> {
            CircularProgress()
        }

        state.questions.isNotEmpty() -> {
            val isLastQuestion = currentStep == state.questions.size - 1

            fun proceedNextQuestion() {
                if (currentStep < state.questions.size - 1) {
                    currentStep++
                    selectedOptionIndex = -1
                    wrongSelectedIndices = emptySet()
                } else {
                    showSuccessDialog = true
                }
            }

            if (showSuccessDialog){
                SuccessDialog(
                    onDismissRequest = {},
                    onConfirm = {
                        showSuccessDialog = false
                        viewModel.saveQuestions()
                        navHostController.popBackStack()
                    },
                    title = stringResource(R.string.congratulations),
                    message = stringResource(R.string.you_have_completed_all_questions)
                )
            }

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .background(color = MaterialTheme.colorScheme.screenBackgroundColor)
                    .windowInsetsPadding(WindowInsets.navigationBars)
                    .windowInsetsPadding(WindowInsets.systemBars)
                    .padding(MEDIUM_PADDING)
            ) {

                Icon(
                    modifier = Modifier
                        .padding(SMALL_PADDING)
                        .clickable {
                            navHostController.popBackStack()
                        },
                    imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                    contentDescription = stringResource(R.string.back),
                    tint = MaterialTheme.colorScheme.iconColor,

                    )
                Spacer(modifier = Modifier.height(SMALL_HEIGHT))

                SegmentedIndicator(
                    totalSteps = state.questions.size,
                    currentStep = currentStep + 1
                )

                Spacer(modifier = Modifier.height(LARGE_HEIGHT))

                Text(
                    text = state.questions[currentStep].questionText,
                    style = MaterialTheme.typography.titleMedium,
                    color = MaterialTheme.colorScheme.primaryTextColor
                )

                Spacer(modifier = Modifier.height(MEDIUM_HEIGHT))

                Options(
                    modifier = Modifier.weight(1f),
                    options = state.questions[currentStep].options,
                    onOptionSelected = { index ->
                        selectedOptionIndex = index
                        if (index != state.questions[currentStep].correctAnswerIndex) {
                            wrongSelectedIndices += index
                        } else {
                            wrongSelectedIndices = emptySet()
                            showBottomSheet = true
                        }
                    },
                    correctAnswerIndex = state.questions[currentStep].correctAnswerIndex,
                    selectedOptionIndex = selectedOptionIndex,
                    wrongSelectedIndices = wrongSelectedIndices
                )

                if (showBottomSheet) {
                    BottomSheet(
                        onDismiss = {
                            showBottomSheet = false
                            showNextButton = true
                        },
                        onNextQuestion = {
                            showBottomSheet = false
                            proceedNextQuestion()
                        },
                        isLastQuestion = isLastQuestion
                    )
                }

                if (showNextButton) {
                    Button(
                        onclick = {
                            showNextButton = false
                            proceedNextQuestion()
                        },
                        text = if (isLastQuestion) stringResource(R.string.finish) else stringResource(R.string.next)
                    )
                }
            }

        }

        state.error.isNotEmpty() -> {
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
                message = "Sorular bulunamadı",
                buttonText = stringResource(R.string.turn_back)
            )
        }

    }
}



