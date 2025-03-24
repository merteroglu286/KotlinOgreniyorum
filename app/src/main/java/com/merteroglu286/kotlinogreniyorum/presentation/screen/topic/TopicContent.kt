package com.merteroglu286.kotlinogreniyorum.presentation.screen.topic

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.merteroglu286.kotlinogreniyorum.domain.model.Topic
import com.merteroglu286.kotlinogreniyorum.ui.theme.primaryTextColor
import com.merteroglu286.kotlinogreniyorum.ui.theme.screenBackgroundColor
import com.merteroglu286.kotlinogreniyorum.ui.theme.secondTextColor

@Composable
fun TopicContent(
    currentTopic: Topic,
    visibleContentCount: Int,
    showExamples: Boolean
) {
    LazyColumn(
        modifier = Modifier.fillMaxWidth()
    ) {
        items(currentTopic.content.take(visibleContentCount)) { content ->
            Text(
                text = content,
                color = MaterialTheme.colorScheme.secondTextColor
            )
            Spacer(modifier = Modifier.height(16.dp))
        }

        if (visibleContentCount < currentTopic.content.size) {
            item {
                ContinueText(text = "Devam etmek için ekrana tıklayın")
            }
        }

        if (visibleContentCount >= currentTopic.content.size && !showExamples) {
            item {
                ContinueText(text = "Örnekleri görmek için ekrana tıklayın")
            }
        }

        if (showExamples) {
            item {
                Spacer(modifier = Modifier.height(24.dp))
                Examples(examples = currentTopic.examples)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun TopicContentPreview() {
    TopicContent(
        currentTopic = fakeTopicList[0],
        visibleContentCount = 1,
        showExamples = true
    )
}

@Preview(showBackground = true, uiMode = UI_MODE_NIGHT_YES)
@Composable
fun TopicContentDarkPreview() {
    Box(
        modifier = Modifier.background(MaterialTheme.colorScheme.screenBackgroundColor)
    ) {
        TopicContent(
            currentTopic = fakeTopicList[0],
            visibleContentCount = 1,
            showExamples = false
        )
    }
}