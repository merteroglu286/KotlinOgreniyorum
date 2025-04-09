package com.merteroglu286.kotlinogreniyorum.presentation.screen.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.navigationBars
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBars
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.zIndex
import androidx.navigation.NavHostController
import com.merteroglu286.kotlinogreniyorum.R
import com.merteroglu286.kotlinogreniyorum.navigation.Screen
import com.merteroglu286.kotlinogreniyorum.presentation.components.CircularProgress
import com.merteroglu286.kotlinogreniyorum.presentation.components.ErrorDialog
import com.merteroglu286.kotlinogreniyorum.presentation.screen.home.components.GreetingSection
import com.merteroglu286.kotlinogreniyorum.presentation.screen.home.components.ModuleList
import com.merteroglu286.kotlinogreniyorum.ui.theme.MEDIUM_PADDING
import com.merteroglu286.kotlinogreniyorum.ui.theme.screenBackgroundColor
import org.koin.androidx.compose.koinViewModel

@Composable
fun HomeScreen(
    navHostController: NavHostController,
    viewModel: HomeViewModel = koinViewModel()
) {
    val state by viewModel.moduleListState.collectAsState()
    val lazyListState = rememberLazyListState()

    val progress by viewModel.progress.collectAsState()
    val completedTopicList by viewModel.completedTopicList.collectAsState()
    val completedQuestionList by viewModel.completedQuestionList.collectAsState()

    val isCompact by remember {
        derivedStateOf {
            lazyListState.firstVisibleItemIndex > 0 || lazyListState.firstVisibleItemScrollOffset > 50
        }
    }

    when {
        state.isLoading -> {
            CircularProgress()
        }

        state.error.isNotEmpty() -> {
            ErrorDialog(
                onDismissRequest = {},
                onConfirm = {
                    viewModel.loadModules()
                },
                message = state.error,
                buttonText = stringResource(R.string.try_again)
            )
        }

        state.modules.isNotEmpty() -> {
        }

        else -> {
            ErrorDialog(
                onDismissRequest = {},
                onConfirm = {
                    viewModel.loadModules()
                },
                message = "Modül bulunamadı",
                buttonText = stringResource(R.string.try_again)
            )
        }
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = MaterialTheme.colorScheme.screenBackgroundColor)
            .windowInsetsPadding(WindowInsets.navigationBars)
            .windowInsetsPadding(WindowInsets.systemBars)
            .padding(MEDIUM_PADDING)
    ) {
        Surface(
            modifier = Modifier
                .fillMaxWidth()
                .zIndex(1f),
            color = MaterialTheme.colorScheme.screenBackgroundColor
        ) {
            GreetingSection(
                progress = progress/100,
                isCompact = isCompact
            )
        }

        ModuleList(
            modules = state.modules,
            completedTopicList = completedTopicList,
            completedQuestionList = completedQuestionList,
            state = lazyListState,
            isCompact = isCompact,
            onContentClick = { moduleId ->
                navHostController.navigate(Screen.Topic.passModuleId(moduleId))
            },
            onQuestionClick = { moduleId ->
                navHostController.navigate(Screen.Question.passModuleId(moduleId))
            }
        )
    }
}

