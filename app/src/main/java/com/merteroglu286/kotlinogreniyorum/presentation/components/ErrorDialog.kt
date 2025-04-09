package com.merteroglu286.kotlinogreniyorum.presentation.components

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.window.Dialog
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.LottieConstants
import com.airbnb.lottie.compose.rememberLottieComposition
import com.merteroglu286.kotlinogreniyorum.R
import com.merteroglu286.kotlinogreniyorum.ui.theme.KotlinOgreniyorumTheme
import com.merteroglu286.kotlinogreniyorum.ui.theme.LARGE_HEIGHT
import com.merteroglu286.kotlinogreniyorum.ui.theme.LOTTIE_IMAGE_SIZE
import com.merteroglu286.kotlinogreniyorum.ui.theme.MEDIUM_HEIGHT
import com.merteroglu286.kotlinogreniyorum.ui.theme.MEDIUM_PADDING
import com.merteroglu286.kotlinogreniyorum.ui.theme.MEDIUM_RADIUS
import com.merteroglu286.kotlinogreniyorum.ui.theme.secondTextColor

@Composable
fun ErrorDialog(
    onDismissRequest: () -> Unit,
    onConfirm: () -> Unit,
    message: String,
    buttonText: String
) {
    val composition by rememberLottieComposition(LottieCompositionSpec.RawRes(R.raw.error))

    Dialog(onDismissRequest = onDismissRequest) {
        Surface(
            shape = RoundedCornerShape(MEDIUM_RADIUS),
            color = MaterialTheme.colorScheme.surface
        ) {
            Column(
                modifier = Modifier.padding(MEDIUM_PADDING),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                LottieAnimation(
                    composition = composition,
                    iterations = LottieConstants.IterateForever,
                    modifier = Modifier.size(LOTTIE_IMAGE_SIZE)
                )

                Spacer(modifier = Modifier.height(MEDIUM_HEIGHT))

                Text(
                    text = message,
                    style = MaterialTheme.typography.bodyMedium,
                    textAlign = TextAlign.Center,
                    color = MaterialTheme.colorScheme.secondTextColor
                )

                Spacer(modifier = Modifier.height(LARGE_HEIGHT))

                Button(
                    onclick = onConfirm,
                    text = buttonText
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ErrorDialogPreview(){
    KotlinOgreniyorumTheme {
        ErrorDialog(
            onDismissRequest = {},
            onConfirm = {},
            message = "Hata mesajı",
            buttonText = "Tekrar dene"
        )
    }
}

@Preview(showBackground = true, uiMode = UI_MODE_NIGHT_YES)
@Composable
fun ErrorDialogDarkPreview(){
    KotlinOgreniyorumTheme {
        ErrorDialog(
            onDismissRequest = {},
            onConfirm = {},
            message = "Hata mesajı.",
            buttonText = "Tekrar dene"
        )
    }
}