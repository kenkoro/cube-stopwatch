package com.kenkoro.stopwatch.view.encapsulated

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import com.kenkoro.stopwatch.model.ScramblerBuilder

@Composable
fun ScramblerAndStopwatch(
    modifier: Modifier = Modifier,
) {
    var label by remember {
        mutableStateOf(
            ScramblerBuilder.generate()
        )
    }

    ScramblerBox(modifier = modifier, label = label)
    StopwatchBox(
        modifier = modifier,
        onLabelChange = { label = it }
    )
}