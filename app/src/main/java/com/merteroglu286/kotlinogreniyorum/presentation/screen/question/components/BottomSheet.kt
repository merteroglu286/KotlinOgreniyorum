package com.merteroglu286.kotlinogreniyorum.presentation.screen.question.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.LottieConstants
import com.airbnb.lottie.compose.rememberLottieComposition
import com.merteroglu286.kotlinogreniyorum.R
import com.merteroglu286.kotlinogreniyorum.presentation.components.Button
import com.merteroglu286.kotlinogreniyorum.ui.theme.LARGE_PADDING
import com.merteroglu286.kotlinogreniyorum.ui.theme.LARGE_SIZE
import com.merteroglu286.kotlinogreniyorum.ui.theme.LOTTIE_IMAGE_SIZE
import com.merteroglu286.kotlinogreniyorum.ui.theme.MEDIUM_HEIGHT
import com.merteroglu286.kotlinogreniyorum.ui.theme.X_LARGE_HEIGHT
import com.merteroglu286.kotlinogreniyorum.ui.theme.X_LARGE_PADDING
import com.merteroglu286.kotlinogreniyorum.ui.theme.primaryTextColor
import com.merteroglu286.kotlinogreniyorum.ui.theme.secondTextColor

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BottomSheet(
    onDismiss: () -> Unit,
    onNextQuestion: () -> Unit,
    isLastQuestion: Boolean
) {
    val sheetState = rememberModalBottomSheetState()
    val composition by rememberLottieComposition(LottieCompositionSpec.RawRes(R.raw.success))

    ModalBottomSheet(
        onDismissRequest = onDismiss,
        sheetState = sheetState
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = LARGE_PADDING, vertical = X_LARGE_PADDING),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            LottieAnimation(
                composition = composition,
                iterations = LottieConstants.IterateForever,
                modifier = Modifier.size(LOTTIE_IMAGE_SIZE)
            )

            Spacer(modifier = Modifier.height(LARGE_SIZE))

            Text(
                text = stringResource(R.string.congratulations),
                style = MaterialTheme.typography.headlineSmall,
                color = MaterialTheme.colorScheme.primaryTextColor
            )

            Spacer(modifier = Modifier.height(MEDIUM_HEIGHT))

            Text(
                text = if (isLastQuestion) stringResource(R.string.click_for_finish) else stringResource(R.string.click_for_next),
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.secondTextColor
            )

            Spacer(modifier = Modifier.height(X_LARGE_HEIGHT))

            Button(
                onclick = onNextQuestion,
                text = if (isLastQuestion) stringResource(R.string.finish) else stringResource(R.string.next)
            )

            Spacer(modifier = Modifier.height(MEDIUM_HEIGHT))
        }
    }
}


