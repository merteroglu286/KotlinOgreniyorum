package com.merteroglu286.kotlinogreniyorum.presentation.screen.home.components

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.merteroglu286.kotlinogreniyorum.domain.model.Module

@Composable
fun ModuleList(
    modules: List<Module>,
    completedTopicList: List<Int>,
    completedQuestionList: List<Int>,
    state: LazyListState,
    isCompact: Boolean,
    onContentClick: (Int) -> Unit,
    onQuestionClick: (Int) -> Unit
) {

    var openCardIndex by remember { mutableIntStateOf(0) }

    for (completedTopic in completedTopicList) {
        for (completedQuestion in completedQuestionList) {
            if (completedTopic == completedQuestion) {
                openCardIndex = completedTopic
            }
        }
    }

    val scrollToIndex = modules.indexOfFirst { it.id == openCardIndex }

    LaunchedEffect(scrollToIndex) {
        if (scrollToIndex != -1 && openCardIndex > 5) {
            state.scrollToItem(scrollToIndex)
        }
    }

    LazyColumn(
        state = state,
        modifier = Modifier
            .fillMaxSize()
            .padding(top = if (isCompact) 64.dp else 124.dp)
    ) {
        items(modules) { module ->
            ExpandableCard(
                module = module,
                completedTopicList = completedTopicList,
                completedQuestionList = completedQuestionList,
                onContentClick = {
                    onContentClick(module.id)
                },
                onQuestionClick = {
                    onQuestionClick(module.id)
                },
                isCardOpen = modules.indexOf(module) == openCardIndex
            )
            Spacer(modifier = Modifier.height(8.dp))
        }
    }
}