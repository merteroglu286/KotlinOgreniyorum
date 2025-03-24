package com.merteroglu286.kotlinogreniyorum.presentation.screen.topic

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.merteroglu286.kotlinogreniyorum.ui.theme.MEDIUM_PADDING
import com.merteroglu286.kotlinogreniyorum.ui.theme.primaryTextColor
import com.merteroglu286.kotlinogreniyorum.ui.theme.screenBackgroundColor
import com.merteroglu286.kotlinogreniyorum.utility.SyntaxHighlighter

@Composable
fun Examples(examples: List<String>) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(color = MaterialTheme.colorScheme.primaryTextColor.copy(alpha = 0.2f))
            .padding(vertical = MEDIUM_PADDING)
    ) {
        examples.forEach { example ->
            Text(
                text = SyntaxHighlighter.highlightKeywords(example),
                style = MaterialTheme.typography.bodyLarge,
                modifier = Modifier
                    .padding(vertical = 4.dp)
                    .padding(horizontal = MEDIUM_PADDING),
                color = MaterialTheme.colorScheme.primaryTextColor
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ExamplesPreview() {
    Examples(
        examples = fakeTopicList[0].examples
    )
}

@Preview(showBackground = true, uiMode = UI_MODE_NIGHT_YES)
@Composable
fun ExamplesDarkPreview() {
    Box(
        modifier = Modifier.background(MaterialTheme.colorScheme.screenBackgroundColor)
    ) {
        Examples(
            examples = fakeTopicList[0].examples
        )
    }
}