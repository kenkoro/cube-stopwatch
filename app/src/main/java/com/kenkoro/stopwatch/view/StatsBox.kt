package com.kenkoro.stopwatch.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
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
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Composable
fun StatsBox(
    height: Dp,
    modifier: Modifier = Modifier,
) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .padding(10.dp)
            .clip(RoundedCornerShape(15.dp))
            .background(MaterialTheme.colorScheme.primaryContainer)
            .height(height),
        contentAlignment = Alignment.TopCenter
    ) {
        Column(
            verticalArrangement = Arrangement.SpaceAround,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .padding(30.dp)
        ) {
            Text(
                text = "Solves: 7",
                color = MaterialTheme.colorScheme.onPrimaryContainer
            )
            Text(
                text = "Mean: 15.06",
                color = MaterialTheme.colorScheme.onPrimaryContainer
            )
            Text(
                text = "Avg 5: 15.37",
                color = MaterialTheme.colorScheme.onPrimaryContainer
            )
            Text(
                text = "Avg 12: -",
                color = MaterialTheme.colorScheme.onPrimaryContainer
            )
        }
    }
}