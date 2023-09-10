package com.kenkoro.stopwatch.view.encapsulated

import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Modifier
import com.kenkoro.stopwatch.view.Stats
import com.kenkoro.stopwatch.view.locals.Heights
import com.kenkoro.stopwatch.view.locals.LocalHeights
import com.kenkoro.stopwatch.view.locals.Paddings

@Composable
fun StatsBox(
    modifier: Modifier = Modifier
) {
    val paddings = Paddings()
    val heights = Heights()
    val stats = listOf(
        "Solves: 7",
        "Mean: 15:06",
        "Avg 5: 15:37",
        "Avg 12: -"
    )

    CompositionLocalProvider(
        LocalHeights provides heights
    ) {
        Stats(
            modifier = modifier,
            height = heights.medium,
            paddings = paddings,
            stats = stats
        )
    }
}