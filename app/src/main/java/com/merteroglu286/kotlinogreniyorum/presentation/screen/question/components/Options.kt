package com.merteroglu286.kotlinogreniyorum.presentation.screen.question.components

import android.content.res.Configuration
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.merteroglu286.kotlinogreniyorum.R
import com.merteroglu286.kotlinogreniyorum.presentation.screen.question.fakeQuestionList
import com.merteroglu286.kotlinogreniyorum.ui.theme.MEDIUM_SIZE
import com.merteroglu286.kotlinogreniyorum.ui.theme.SMALL_PADDING
import com.merteroglu286.kotlinogreniyorum.ui.theme.SMALL_SIZE
import com.merteroglu286.kotlinogreniyorum.ui.theme.correctAnswerColor
import com.merteroglu286.kotlinogreniyorum.ui.theme.primaryTextColor
import com.merteroglu286.kotlinogreniyorum.ui.theme.screenBackgroundColor
import com.merteroglu286.kotlinogreniyorum.ui.theme.wrongAnswerColor

@Composable
fun Options(
    modifier: Modifier,
    options: List<String>,
    onOptionSelected: (Int) -> Unit,
    correctAnswerIndex: Int,
    selectedOptionIndex: Int,
    wrongSelectedIndices: Set<Int>
) {
    LazyColumn(
        modifier = modifier
            .fillMaxWidth()
    ) {
        itemsIndexed(options) { index, option ->
            val isCorrect = index == correctAnswerIndex
            val isSelected = index == selectedOptionIndex
            val isWrongSelected = wrongSelectedIndices.contains(index)
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = SMALL_PADDING)
                    .background(
                        color = when {
                            isSelected && isCorrect -> MaterialTheme.colorScheme.correctAnswerColor
                            isWrongSelected -> MaterialTheme.colorScheme.wrongAnswerColor
                            else -> MaterialTheme.colorScheme.primaryTextColor.copy(alpha = 0.2f)
                        }
                    )
                    .padding(SMALL_PADDING)
                    .clickable {
                        onOptionSelected(index)
                    },
                verticalAlignment = Alignment.CenterVertically
            ) {

                Icon(
                    painter = painterResource(R.drawable.ic_circle),
                    contentDescription = null,
                    tint = MaterialTheme.colorScheme.primaryTextColor,
                    modifier = Modifier.size(MEDIUM_SIZE)
                )

                Spacer(modifier = Modifier.size(SMALL_SIZE))

                Text(
                    text = option,
                    modifier = Modifier.fillMaxWidth(),
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.primaryTextColor
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun OptionsPreview() {
    Options(
        modifier = Modifier,
        options = fakeQuestionList[1].options,
        onOptionSelected = {},
        correctAnswerIndex = 1,
        selectedOptionIndex = 1,
        wrongSelectedIndices = setOf(2,3)
    )
}

@Preview(showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun OptionsDarkPreview() {
    Box(
        modifier = Modifier.background(MaterialTheme.colorScheme.screenBackgroundColor)
    ) {
        Options(
            modifier = Modifier,
            options = fakeQuestionList[1].options,
            onOptionSelected = {},
            correctAnswerIndex = 1,
            selectedOptionIndex = 1,
            wrongSelectedIndices = setOf(2,3)
        )
    }
}