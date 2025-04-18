package com.merteroglu286.kotlinogreniyorum.presentation.components

import android.content.res.Configuration
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.merteroglu286.kotlinogreniyorum.ui.theme.ActiveSegmentedIndicatorColor
import com.merteroglu286.kotlinogreniyorum.ui.theme.InactiveSegmentedIndicatorColor
import com.merteroglu286.kotlinogreniyorum.ui.theme.MEDIUM_PADDING
import com.merteroglu286.kotlinogreniyorum.ui.theme.SMALL_HEIGHT
import com.merteroglu286.kotlinogreniyorum.ui.theme.screenBackgroundColor

@Composable
fun SegmentedIndicator(totalSteps: Int, currentStep: Int) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(MEDIUM_PADDING),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        for (i in 1..totalSteps) {
            Box(
                modifier = Modifier
                    .weight(1f)
                    .height(SMALL_HEIGHT)
                    .padding(horizontal = 2.dp)
                    .background(
                        color =
                            if (i <= currentStep) MaterialTheme.colorScheme.ActiveSegmentedIndicatorColor
                            else MaterialTheme.colorScheme.InactiveSegmentedIndicatorColor,
                        shape = RoundedCornerShape(2.dp)
                    )
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewSegmentedIndicator() {
    SegmentedIndicator(totalSteps = 5, currentStep = 3)
}

@Preview(showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun DarkPreviewSegmentedIndicator() {
    Box(
        modifier = Modifier.background(MaterialTheme.colorScheme.screenBackgroundColor)
    ) {
        SegmentedIndicator(totalSteps = 5, currentStep = 3)
    }
}