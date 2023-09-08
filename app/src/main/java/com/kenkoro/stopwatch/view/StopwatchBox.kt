package com.kenkoro.stopwatch.view

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.hapticfeedback.HapticFeedbackType
import androidx.compose.ui.platform.LocalHapticFeedback
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.kenkoro.stopwatch.model.Stopwatch

@Composable
fun StopwatchBox(
    modifier: Modifier = Modifier,
    formattedTime: String,
    stopwatch: Stopwatch,
    onStartClick: () -> Unit,
    onResetClick: () -> Unit,
    onPauseClick: () -> Unit
) {
    val haptic = LocalHapticFeedback.current
    Box(
        modifier = modifier
            .size(300.dp)
            .padding(10.dp)
            .clip(CircleShape)
            .background(MaterialTheme.colorScheme.primaryContainer)
            .clickable {
                haptic.performHapticFeedback(HapticFeedbackType.LongPress)
                if (stopwatch.isRunning) {
                    onPauseClick()
                } else {
                    when (stopwatch.formattedTime) {
                        "00:00" -> onStartClick()
                        else -> onResetClick()
                    }
                }
            }, contentAlignment = Alignment.Center
    ) {
        Text(
            text = formattedTime,
            color = MaterialTheme.colorScheme.onPrimaryContainer,
            fontSize = 64.sp,
            textAlign = TextAlign.Center
        )
    }
}