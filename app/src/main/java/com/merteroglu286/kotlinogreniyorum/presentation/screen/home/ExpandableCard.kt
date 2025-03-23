package com.merteroglu286.kotlinogreniyorum.presentation.screen.home

import android.graphics.Color
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.expandVertically
import androidx.compose.animation.shrinkVertically
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowRight
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material.icons.outlined.Info
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.merteroglu286.kotlinogreniyorum.R
import com.merteroglu286.kotlinogreniyorum.domain.model.Module
import com.merteroglu286.kotlinogreniyorum.ui.theme.DividerColor
import com.merteroglu286.kotlinogreniyorum.ui.theme.MEDIUM_PADDING
import com.merteroglu286.kotlinogreniyorum.ui.theme.cardBackgroundColor
import com.merteroglu286.kotlinogreniyorum.ui.theme.descriptionColor
import com.merteroglu286.kotlinogreniyorum.ui.theme.expandedCardBackgroundColor
import com.merteroglu286.kotlinogreniyorum.ui.theme.titleColor

@Composable
fun ExpandableCard(
    module: Module,
    onContentClick: () -> Unit,
    onQuestionClick: () -> Unit,
    isFirstCard: Boolean
) {
    var isExpanded by rememberSaveable { mutableStateOf(isFirstCard) }
    val rotationState by animateFloatAsState(
        targetValue = if (isExpanded) 180f else 0f
    )

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp),
        shape = RectangleShape,
        elevation = CardDefaults.cardElevation(
            defaultElevation = 4.dp
        )
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(MaterialTheme.colorScheme.cardBackgroundColor)
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable { isExpanded = !isExpanded }
                    .padding(MEDIUM_PADDING),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = module.title,
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.titleColor
                )

                Icon(
                    imageVector = Icons.Default.KeyboardArrowDown,
                    contentDescription = if (isExpanded) "Daralt" else "Genişlet",
                    modifier = Modifier.rotate(rotationState),
                    tint = MaterialTheme.colorScheme.titleColor
                )
            }

            AnimatedVisibility(
                visible = isExpanded,
                enter = expandVertically(),
                exit = shrinkVertically()
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(color = MaterialTheme.colorScheme.expandedCardBackgroundColor)
                        .padding(
                            start = MEDIUM_PADDING,
                            end = MEDIUM_PADDING,
                            bottom = MEDIUM_PADDING
                        )
                ) {

                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = MEDIUM_PADDING),
                        horizontalArrangement = Arrangement.Start,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Icon(
                            imageVector = Icons.Outlined.Info,
                            contentDescription = "Bilgi",
                            tint = MaterialTheme.colorScheme.descriptionColor
                        )

                        Spacer(modifier = Modifier.width(8.dp))

                        Text(
                            text = module.description,
                            style = MaterialTheme.typography.bodyMedium,
                            color = MaterialTheme.colorScheme.descriptionColor
                        )
                    }

                    HorizontalDivider(
                        color = MaterialTheme.colorScheme.DividerColor
                    )

                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .clickable {
                                onContentClick()
                            }
                    ) {
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(vertical = MEDIUM_PADDING),
                            horizontalArrangement = Arrangement.Start,
                            verticalAlignment = Alignment.CenterVertically,
                        ) {
                            Icon(
                                modifier = Modifier.size(24.dp),
                                painter = painterResource(R.drawable.ic_programming),
                                contentDescription = "Bilgi",
                                tint = MaterialTheme.colorScheme.descriptionColor
                            )

                            Spacer(modifier = Modifier.width(8.dp))

                            Text(
                                text = "Öğrenmeye başla.",
                                style = MaterialTheme.typography.bodyMedium,
                                color = MaterialTheme.colorScheme.descriptionColor
                            )

                            Spacer(modifier = Modifier.weight(1f))

                            Icon(
                                imageVector = Icons.AutoMirrored.Filled.KeyboardArrowRight,
                                contentDescription = "Git",
                                tint = MaterialTheme.colorScheme.descriptionColor
                            )
                        }
                    }

                    HorizontalDivider(
                        color = MaterialTheme.colorScheme.DividerColor
                    )

                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .clickable {
                                onQuestionClick()
                            }
                    ) {
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(vertical = MEDIUM_PADDING),
                            horizontalArrangement = Arrangement.Start,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Icon(
                                modifier = Modifier.size(24.dp),
                                painter = painterResource(R.drawable.ic_question),
                                contentDescription = "Soru",
                                tint = MaterialTheme.colorScheme.descriptionColor
                            )

                            Spacer(modifier = Modifier.width(8.dp))

                            Text(
                                text = "Soruları çöz.",
                                style = MaterialTheme.typography.bodyMedium,
                                color = MaterialTheme.colorScheme.descriptionColor
                            )

                            Spacer(modifier = Modifier.weight(1f))

                            Icon(
                                imageVector = Icons.AutoMirrored.Filled.KeyboardArrowRight,
                                contentDescription = "Git",
                                tint = MaterialTheme.colorScheme.descriptionColor
                            )
                        }

                    }


                }
            }
        }
    }
}