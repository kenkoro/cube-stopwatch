package com.kenkoro.stopwatch.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.kenkoro.stopwatch.view.locals.LocalPaddings
import com.kenkoro.stopwatch.view.locals.Paddings

@Composable
fun Stats(
    modifier: Modifier = Modifier,
    height: Dp,
    paddings: Paddings,
    stats: List<String>
) {
    CompositionLocalProvider(
        LocalPaddings provides paddings
    ) {
        Box(
            modifier = modifier
                .fillMaxWidth()
                .padding(paddings.default)
                .clip(RoundedCornerShape(15.dp))
                .background(MaterialTheme.colorScheme.primaryContainer)
                .height(height),
            contentAlignment = Alignment.TopCenter
        ) {
            LazyColumn(
                verticalArrangement = Arrangement.SpaceAround,
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .padding(paddings.extraLarge)
            ) {
                items(stats.size) { index ->
                    Text(
                        text = stats[index],
                        color = MaterialTheme.colorScheme.onPrimaryContainer
                    )
                }
            }
        }
    }
}