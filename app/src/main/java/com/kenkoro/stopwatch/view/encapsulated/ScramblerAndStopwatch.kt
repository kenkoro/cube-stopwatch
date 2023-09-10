package com.kenkoro.stopwatch.view.encapsulated

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import com.kenkoro.stopwatch.model.ScramblerBuilder

@Composable
fun ScramblerAndStopwatch() {
    var label by remember {
        mutableStateOf(
            ScramblerBuilder.generate()
        )
    }

    ScramblerBox(label = label)
    StopwatchBox(onLableChange = { label = it })
}