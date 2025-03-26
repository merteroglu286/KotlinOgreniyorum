package com.merteroglu286.kotlinogreniyorum.presentation.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.merteroglu286.kotlinogreniyorum.ui.theme.BUTTON_HEIGHT
import com.merteroglu286.kotlinogreniyorum.ui.theme.buttonColor
import com.merteroglu286.kotlinogreniyorum.ui.theme.buttonTextColor

@Composable
fun Button(
    onclick: () -> Unit,
    text: String
){
    androidx.compose.material3.Button(
        onClick = onclick,
        modifier = Modifier
            .fillMaxWidth()
            .height(BUTTON_HEIGHT),
        colors = ButtonDefaults.buttonColors(
            containerColor = MaterialTheme.colorScheme.buttonColor,
            contentColor = MaterialTheme.colorScheme.buttonTextColor
        )
    ) {
        Text(text = text)
    }
}