package com.merteroglu286.kotlinogreniyorum.presentation.screen.topic.components

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import com.merteroglu286.kotlinogreniyorum.domain.model.Topic
import com.merteroglu286.kotlinogreniyorum.ui.theme.LARGE_HEIGHT
import com.merteroglu286.kotlinogreniyorum.ui.theme.MEDIUM_HEIGHT
import com.merteroglu286.kotlinogreniyorum.ui.theme.secondTextColor

@Composable
fun TopicContent(
    currentTopic: Topic,
    visibleContentCount: Int,
    showExamples: Boolean
) {
    val listState = rememberLazyListState()

    LazyColumn(
        modifier = Modifier.fillMaxWidth(),
        state = listState
    ) {
        items(currentTopic.content.take(visibleContentCount)) { content ->
            Text(
                text = content,
                color = MaterialTheme.colorScheme.secondTextColor
            )
            Spacer(modifier = Modifier.height(MEDIUM_HEIGHT))
        }

        if (visibleContentCount < currentTopic.content.size) {
            item {
                ContinueText(text = "Devam etmek için ekrana tıklayın")
            }
        }

        if (visibleContentCount >= currentTopic.content.size && !showExamples && currentTopic.examples.isNotEmpty()) {
            item {
                ContinueText(text = "Örnekleri görmek için ekrana tıklayın")
            }
        }

        if (showExamples && currentTopic.examples.isNotEmpty()) {
            item {
                Spacer(modifier = Modifier.height(LARGE_HEIGHT))
                Examples(examples = currentTopic.examples)
            }
        }
    }

    LaunchedEffect(visibleContentCount, showExamples) {
        listState.animateScrollToItem(listState.layoutInfo.totalItemsCount - 1)
    }

}