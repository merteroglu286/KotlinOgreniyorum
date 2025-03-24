package com.merteroglu286.kotlinogreniyorum.presentation.screen.topic

import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.merteroglu286.kotlinogreniyorum.domain.model.Topic
import com.merteroglu286.kotlinogreniyorum.ui.theme.primaryTextColor

@Composable
fun TopicScreenContent(
    currentTopic: Topic,
    currentStep: Int,
    totalSteps: Int,
    visibleContentCount: Int,
    showExamples: Boolean,
    isLastTopic: Boolean,
    onContentClick: () -> Unit,
    onResetClick: () -> Unit,
    onNextClick: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .clickable(
                interactionSource = remember { MutableInteractionSource() },
                indication = null,
                onClick = onContentClick
            ),
        verticalArrangement = Arrangement.Center
    ) {
        SegmentedIndicator(totalSteps = totalSteps, currentStep = currentStep + 1)

        Spacer(modifier = Modifier.height(32.dp))

        Text(
            text = currentTopic.title,
            color = MaterialTheme.colorScheme.primaryTextColor,
            style = MaterialTheme.typography.titleLarge
        )

        Spacer(modifier = Modifier.height(16.dp))

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
        ) {
            TopicContent(
                currentTopic = currentTopic,
                visibleContentCount = visibleContentCount,
                showExamples = showExamples
            )
        }

        if (visibleContentCount >= currentTopic.content.size && showExamples) {
            Spacer(modifier = Modifier.height(16.dp))
            Buttons(
                isLastTopic = isLastTopic,
                onResetClick = onResetClick,
                onNextClick = onNextClick
            )
        }
    }
}