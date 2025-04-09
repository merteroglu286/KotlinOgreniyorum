package com.merteroglu286.kotlinogreniyorum.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.zIndex
import com.merteroglu286.kotlinogreniyorum.ui.theme.circularProgressColor
import com.merteroglu286.kotlinogreniyorum.ui.theme.screenBackgroundColor

@Composable
fun CircularProgress() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                color = MaterialTheme.colorScheme.screenBackgroundColor
            )
            .zIndex(2f),
        contentAlignment = Alignment.Center
    ) {
        CircularProgressIndicator(
            color = MaterialTheme.colorScheme.circularProgressColor
        )
    }

}