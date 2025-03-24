package com.merteroglu286.kotlinogreniyorum.presentation.screen.topic

import android.content.res.Configuration
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.merteroglu286.kotlinogreniyorum.ui.theme.screenBackgroundColor
import com.merteroglu286.kotlinogreniyorum.ui.theme.thirdTextColor

@Composable
fun ContinueText(text: String) {
    Text(
        text = text,
        color = MaterialTheme.colorScheme.thirdTextColor,
        style = MaterialTheme.typography.bodySmall,
        modifier = Modifier.padding(top = 8.dp)
    )
}

@Preview(showBackground = true)
@Composable
fun ContinueTextPreview() {
    ContinueText(text = "Devam etmek için ekrana tıklayın")
}

@Preview(showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun ContinueTextDarkPreview() {
    Box(
        modifier = Modifier
            .background(MaterialTheme.colorScheme.screenBackgroundColor)
    ){
        ContinueText(text = "Devam etmek için ekrana tıklayın")
    }
}