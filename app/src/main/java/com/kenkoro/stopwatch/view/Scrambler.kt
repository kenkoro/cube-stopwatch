package com.kenkoro.stopwatch.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
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
fun PathBuilder(
    modifier: Modifier = Modifier,
    padding: Dp,
    height: Dp,
    label: String
) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .padding(padding)
            .clip(RoundedCornerShape(15.dp))
            .background(MaterialTheme.colorScheme.primaryContainer)
            .height(height),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = label,
            color = MaterialTheme.colorScheme.onPrimaryContainer,
            letterSpacing = 5.sp,
            style = MaterialTheme.typography.bodyLarge,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .padding(padding)
        )
    }
}