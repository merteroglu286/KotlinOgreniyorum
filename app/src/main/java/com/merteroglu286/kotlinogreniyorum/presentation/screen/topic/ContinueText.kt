package com.merteroglu286.kotlinogreniyorum.presentation.screen.topic

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.merteroglu286.kotlinogreniyorum.ui.theme.DarkGray

@Composable
fun ContinueText(text: String) {
    Text(
        text = text,
        color = DarkGray,
        style = MaterialTheme.typography.bodySmall,
        modifier = Modifier.padding(top = 8.dp)
    )
}