package com.merteroglu286.kotlinogreniyorum.presentation.screen.topic

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun Buttons(
    isLastTopic: Boolean,
    onResetClick: () -> Unit,
    onNextClick: () -> Unit
) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        OutlinedButton(
            onClick = onResetClick,
            modifier = Modifier.weight(1f)
        ) {
            Text("Başa Dön")
        }

        Button(
            onClick = onNextClick,
            modifier = Modifier.weight(1f)
        ) {
            Text(if (isLastTopic) "Tamamla" else "Anladım")
        }
    }
}
