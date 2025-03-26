package com.merteroglu286.kotlinogreniyorum.presentation.screen.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBars
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBars
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
import androidx.navigation.NavHostController
import com.merteroglu286.kotlinogreniyorum.domain.model.Module
import com.merteroglu286.kotlinogreniyorum.navigation.Screen
import com.merteroglu286.kotlinogreniyorum.presentation.screen.home.components.ExpandableCard
import com.merteroglu286.kotlinogreniyorum.presentation.screen.home.components.GreetingSection
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

    val isCompact by remember {
        derivedStateOf {
            lazyListState.firstVisibleItemIndex > 0 || lazyListState.firstVisibleItemScrollOffset > 50
        }
    }

    /*when {
            state.isLoading -> {
                CircularProgressIndicator(
                    modifier = Modifier.align(Alignment.Center),
                    color = MaterialTheme.colorScheme.primary
                )
            }

            state.error.isNotEmpty() -> {
                Text(
                    text = state.error,
                    color = Color.Red,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.align(Alignment.Center)
                )
            }

            state.modules.isNotEmpty() -> {
                ModuleList(
                    modules = state.modules,
                    onModuleClick = { moduleId ->
                        // Burada seçilen modüle göre navigasyon işlemi yapabilirsiniz
                        // Örnek: navHostController.navigate("module_detail/$moduleId")
                    }
                )
            }

            else -> {
                Text(
                    text = "Modül bulunamadı",
                    modifier = Modifier.align(Alignment.Center),
                    color = Color.LightGray
                )
            }
        }*/

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
                progress = 0.7f,
                isCompact = isCompact
            )
        }

        ModuleList(
            modules = fakeModuleList,
            state = lazyListState,
            isCompact = isCompact,
            onContentClick = {
                navHostController.navigate(Screen.Topic.route)
            },
            onQuestionClick = {
                navHostController.navigate(Screen.Question.route)
            }
        )
    }
}

@Composable
fun ModuleList(
    modules: List<Module>,
    state: LazyListState,
    isCompact: Boolean,
    onContentClick: () -> Unit,
    onQuestionClick: () -> Unit
) {
    LazyColumn(
        state = state,
        modifier = Modifier
            .fillMaxSize()
            .padding(top = if (isCompact) 64.dp else 124.dp)
    ) {
        items(modules) { module ->
            ExpandableCard(
                module = module,
                onContentClick = {
                   onContentClick()
                },
                onQuestionClick = {
                    onQuestionClick()
                },
                isFirstCard = fakeModuleList.indexOf(module) == 0
            )
            Spacer(modifier = Modifier.height(8.dp))
        }
    }
}