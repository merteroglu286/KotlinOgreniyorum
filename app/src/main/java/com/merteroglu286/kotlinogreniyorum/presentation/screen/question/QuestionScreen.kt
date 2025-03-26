package com.merteroglu286.kotlinogreniyorum.presentation.screen.question

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBars
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBars
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
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
import com.merteroglu286.kotlinogreniyorum.presentation.screen.question.components.BottomSheet
import com.merteroglu286.kotlinogreniyorum.presentation.screen.question.components.Options
import com.merteroglu286.kotlinogreniyorum.presentation.components.SegmentedIndicator
import com.merteroglu286.kotlinogreniyorum.ui.theme.LARGE_HEIGHT
import com.merteroglu286.kotlinogreniyorum.ui.theme.MEDIUM_HEIGHT
import com.merteroglu286.kotlinogreniyorum.ui.theme.MEDIUM_PADDING
import com.merteroglu286.kotlinogreniyorum.ui.theme.primaryTextColor
import com.merteroglu286.kotlinogreniyorum.ui.theme.screenBackgroundColor
import org.koin.androidx.compose.koinViewModel

@Composable
fun QuestionScreen(
    navHostController: NavHostController,
    viewModel: QuestionViewModel = koinViewModel()
) {

    var currentStep by rememberSaveable { mutableIntStateOf(0) }
    var selectedOptionIndex by rememberSaveable { mutableIntStateOf(-1) }
    var wrongSelectedIndices by rememberSaveable { mutableStateOf(setOf<Int>()) }
    var showBottomSheet by rememberSaveable { mutableStateOf(false) }
    var showNextButton by rememberSaveable { mutableStateOf(false) }

    fun proceedNextQuestion(){
        if (currentStep < fakeQuestionList.size - 1) {
            currentStep++
            selectedOptionIndex = -1
            wrongSelectedIndices = emptySet()
        } else {
            navHostController.popBackStack()
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = MaterialTheme.colorScheme.screenBackgroundColor)
            .windowInsetsPadding(WindowInsets.navigationBars)
            .windowInsetsPadding(WindowInsets.systemBars)
            .padding(MEDIUM_PADDING)
    ) {

        SegmentedIndicator(
            totalSteps = fakeQuestionList.size,
            currentStep = currentStep + 1
        )

        Spacer(modifier = Modifier.height(LARGE_HEIGHT))

        Text(
            text = fakeQuestionList[currentStep].questionText,
            style = MaterialTheme.typography.titleMedium,
            color = MaterialTheme.colorScheme.primaryTextColor
        )

        Spacer(modifier = Modifier.height(MEDIUM_HEIGHT))

        Options(
            modifier = Modifier.weight(1f),
            options = fakeQuestionList[currentStep].options,
            onOptionSelected = { index ->
                selectedOptionIndex = index
                if (index != fakeQuestionList[currentStep].correctAnswerIndex) {
                    wrongSelectedIndices += index
                }else{
                    wrongSelectedIndices = emptySet()
                    showBottomSheet = true
                }
            },
            correctAnswerIndex = fakeQuestionList[currentStep].correctAnswerIndex,
            selectedOptionIndex = selectedOptionIndex,
            wrongSelectedIndices = wrongSelectedIndices
        )

        if (showBottomSheet){
            BottomSheet(
                onDismiss = {
                    showBottomSheet = false
                    showNextButton = true
                },
                onNextQuestion = {
                    showBottomSheet = false
                    proceedNextQuestion()
                }
            )
        }

        if (showNextButton){
            Button(
                onclick = {
                    proceedNextQuestion()
                },
                text = stringResource(R.string.next)
            )
        }
    }


}



