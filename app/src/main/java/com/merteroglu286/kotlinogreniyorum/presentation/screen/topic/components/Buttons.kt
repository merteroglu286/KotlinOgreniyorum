package com.merteroglu286.kotlinogreniyorum.presentation.screen.topic.components

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.merteroglu286.kotlinogreniyorum.R
import com.merteroglu286.kotlinogreniyorum.ui.theme.SMALL_PADDING
import com.merteroglu286.kotlinogreniyorum.ui.theme.buttonColor
import com.merteroglu286.kotlinogreniyorum.ui.theme.buttonTextColor
import com.merteroglu286.kotlinogreniyorum.ui.theme.outlinedButtonColor
import com.merteroglu286.kotlinogreniyorum.ui.theme.screenBackgroundColor

@Composable
fun Buttons(
    isLastTopic: Boolean,
    isFirsTopic: Boolean,
    onResetClick: () -> Unit,
    onNextClick: () -> Unit
) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(SMALL_PADDING)
    ) {
        if (!isFirsTopic){
            OutlinedButton(
                onClick = onResetClick,
                modifier = Modifier.weight(1f),
                border = BorderStroke(
                    width = 1.dp,
                    color = MaterialTheme.colorScheme.outlinedButtonColor
                ),
                colors = ButtonDefaults.outlinedButtonColors(
                    contentColor = MaterialTheme.colorScheme.outlinedButtonColor
                )
            ) {
                Text("Başa Dön")
            }
        }
        Button(
            onClick = onNextClick,
            modifier = Modifier.weight(1f),
            colors = ButtonDefaults.
            buttonColors(
                containerColor =
                    MaterialTheme.colorScheme.buttonColor,
                contentColor = MaterialTheme.colorScheme.buttonTextColor
            )
        )
        {
            Text(if (isLastTopic) stringResource(R.string.finish) else stringResource(R.string.next))
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ButtonsPreview() {
    Buttons(
        isLastTopic = false,
        isFirsTopic = false,
        onResetClick = {},
        onNextClick = {}
    )
}

@Preview(showBackground = true, uiMode = UI_MODE_NIGHT_YES)
@Composable
fun ButtonsDarkPreview() {
    Box(
        modifier = Modifier.background(MaterialTheme.colorScheme.screenBackgroundColor)
    ) {
        Buttons(
            isLastTopic = false,
            isFirsTopic = false,
            onResetClick = {},
            onNextClick = {}
        )
    }
}