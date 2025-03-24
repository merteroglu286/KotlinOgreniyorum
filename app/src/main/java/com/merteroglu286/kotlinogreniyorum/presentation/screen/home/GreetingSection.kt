package com.merteroglu286.kotlinogreniyorum.presentation.screen.home

import android.content.res.Configuration
import android.os.Build
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.background
import androidx.compose.ui.res.stringResource
import com.merteroglu286.kotlinogreniyorum.R
import com.merteroglu286.kotlinogreniyorum.ui.theme.HeaderTitleColor
import com.merteroglu286.kotlinogreniyorum.ui.theme.MEDIUM_PADDING
import com.merteroglu286.kotlinogreniyorum.ui.theme.ProgressIndicatorColor
import com.merteroglu286.kotlinogreniyorum.ui.theme.ProgressIndicatorTrackColor
import com.merteroglu286.kotlinogreniyorum.ui.theme.primaryTextColor
import com.merteroglu286.kotlinogreniyorum.ui.theme.screenBackgroundColor
import java.time.LocalTime
import java.util.Calendar

@Composable
fun GreetingSection(
    progress: Float,
    isCompact: Boolean
) {
    val hour = remember {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            LocalTime.now().hour
        } else {
            Calendar.getInstance().get(Calendar.HOUR_OF_DAY)
        }
    }

    val greetingText = when (hour) {
        in 5..11 -> stringResource(R.string.good_morning)
        in 12..17 -> stringResource(R.string.good_day)
        in 18..22 -> stringResource(R.string.good_evening)
        else -> stringResource(R.string.good_night)
    }

    val paddingAnimation by animateFloatAsState(
        targetValue = if (isCompact) 8f else 16f,
        animationSpec = tween(durationMillis = 100, easing = FastOutSlowInEasing)
    )

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(color = MaterialTheme.colorScheme.screenBackgroundColor)
            .padding(
                vertical = paddingAnimation.dp,
                horizontal = MEDIUM_PADDING
            )
            .animateContentSize(
                animationSpec = tween(
                    durationMillis = 300,
                    easing = FastOutSlowInEasing
                )
            )
    ) {
        AnimatedVisibility(
            visible = !isCompact,
            enter = fadeIn(animationSpec = tween(durationMillis = 100)),
            exit = fadeOut(animationSpec = tween(durationMillis = 100))
        ) {
            Column {
                Text(
                    text = greetingText,
                    style = MaterialTheme.typography.headlineSmall,
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.HeaderTitleColor
                )

                Spacer(modifier = Modifier.height(8.dp))
            }
        }

        Text(
            text = "${stringResource(R.string.your_progress)} ${(progress * 100).toInt()}%",
            style = MaterialTheme.typography.bodyMedium,
            color = MaterialTheme.colorScheme.primaryTextColor
        )

        Spacer(modifier = Modifier.height(4.dp))

        LinearProgressIndicator(
            progress = { progress },
            modifier = Modifier
                .fillMaxWidth()
                .height(8.dp)
                .clip(RoundedCornerShape(4.dp)),
            color = MaterialTheme.colorScheme.ProgressIndicatorColor,
            trackColor = MaterialTheme.colorScheme.ProgressIndicatorTrackColor
        )
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingSectionExpandedPreview() {
    GreetingSection(progress = 0.6f, isCompact = false)
}

@Preview(showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun GreetingSectionExpandedDarkPreview() {
    GreetingSection(progress = 0.6f, isCompact = false)
}