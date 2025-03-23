package com.merteroglu286.kotlinogreniyorum.presentation.screen.topic

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.merteroglu286.kotlinogreniyorum.ui.theme.MEDIUM_PADDING
import com.merteroglu286.kotlinogreniyorum.ui.theme.defaultTextColor
import com.merteroglu286.kotlinogreniyorum.utility.SyntaxHighlighter

@Composable
fun Examples(examples: List<String>) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(color = MaterialTheme.colorScheme.defaultTextColor.copy(alpha = 0.2f))
    ) {
        examples.forEach { example ->
            Text(
                text = SyntaxHighlighter.highlightKeywords(example),
                style = MaterialTheme.typography.bodyLarge,
                modifier = Modifier
                    .padding(vertical = 4.dp)
                    .padding(horizontal = MEDIUM_PADDING)
            )
        }
    }
}