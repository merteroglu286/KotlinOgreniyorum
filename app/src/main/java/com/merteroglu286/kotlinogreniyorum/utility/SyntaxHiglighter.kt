package com.merteroglu286.kotlinogreniyorum.utility

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.withStyle
import com.merteroglu286.kotlinogreniyorum.ui.theme.syntaxHighlighterColor

object SyntaxHighlighter {

    @Composable
    fun highlightKeywords(text: String): AnnotatedString {
        val keywords = listOf("val", "var", "fun", "private", "class", "return", "if", "else", "for", "while", "when")

        return buildAnnotatedString {
            val words = text.split(" ")
            for (word in words) {
                if (keywords.contains(word)) {
                    withStyle(style = SpanStyle(color = MaterialTheme.colorScheme.syntaxHighlighterColor)) {
                        append("$word ")
                    }
                } else {
                    append("$word ")
                }
            }
        }
    }
}