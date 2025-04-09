package com.merteroglu286.kotlinogreniyorum.presentation.screen.topic.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.merteroglu286.kotlinogreniyorum.R
import com.merteroglu286.kotlinogreniyorum.domain.model.Topic
import com.merteroglu286.kotlinogreniyorum.presentation.components.SegmentedIndicator
import com.merteroglu286.kotlinogreniyorum.ui.theme.MEDIUM_HEIGHT
import com.merteroglu286.kotlinogreniyorum.ui.theme.SMALL_HEIGHT
import com.merteroglu286.kotlinogreniyorum.ui.theme.SMALL_PADDING
import com.merteroglu286.kotlinogreniyorum.ui.theme.X_LARGE_HEIGHT
import com.merteroglu286.kotlinogreniyorum.ui.theme.iconColor
import com.merteroglu286.kotlinogreniyorum.ui.theme.primaryTextColor

@Composable
fun TopicScreenContent(
    currentTopic: Topic,
    currentStep: Int,
    totalSteps: Int,
    visibleContentCount: Int,
    showExamples: Boolean,
    isLastTopic: Boolean,
    isFirsTopic: Boolean,
    onBackClick: () -> Unit,
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

        Icon(
            modifier = Modifier
                .padding(SMALL_PADDING)
                .clickable { onBackClick() },
            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
            contentDescription = stringResource(R.string.back),
            tint = MaterialTheme.colorScheme.iconColor,

            )

        Spacer(modifier = Modifier.height(SMALL_HEIGHT))

        SegmentedIndicator(totalSteps = totalSteps, currentStep = currentStep + 1)

        Spacer(modifier = Modifier.height(X_LARGE_HEIGHT))

        Text(
            text = currentTopic.title,
            color = MaterialTheme.colorScheme.primaryTextColor,
            style = MaterialTheme.typography.titleLarge
        )

        Spacer(modifier = Modifier.height(MEDIUM_HEIGHT))

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

        if (visibleContentCount >= currentTopic.content.size && showExamples ||
            (visibleContentCount >= currentTopic.content.size && currentTopic.examples.isEmpty())
        ) {
            Spacer(modifier = Modifier.height(MEDIUM_HEIGHT))
            Buttons(
                isLastTopic = isLastTopic,
                isFirsTopic = isFirsTopic,
                onResetClick = onResetClick,
                onNextClick = onNextClick
            )
        }
    }
}