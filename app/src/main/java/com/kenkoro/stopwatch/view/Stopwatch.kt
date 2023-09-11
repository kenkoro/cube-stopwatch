package com.kenkoro.stopwatch.view

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.kenkoro.stopwatch.view.bars.BottomBarHost
import com.kenkoro.stopwatch.view.screens.RecordScreen
import com.kenkoro.stopwatch.view.screens.StopwatchScreen

@Composable
fun Stopwatch(
    modifier: Modifier = Modifier
) {
    BottomBarHost(modifier = modifier) { index ->
        when (index) {
            1 -> RecordScreen()
            else -> StopwatchScreen()
        }
    }
}