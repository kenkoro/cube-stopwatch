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
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun StopwatchUi(
    modifier: Modifier = Modifier,
    padding: Dp,
    formattedTime: String,
    onClick: () -> Unit,
) {
    Box(
        modifier = modifier
            .size(300.dp)
            .padding(padding)
            .clip(CircleShape)
            .background(MaterialTheme.colorScheme.primaryContainer)
            .clickable { onClick() },
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = formattedTime,
            color = MaterialTheme.colorScheme.onPrimaryContainer,
            fontSize = 64.sp,
            textAlign = TextAlign.Center
        )
    }
}