package com.kenkoro.stopwatch.view.encapsulated

import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Modifier
import com.kenkoro.stopwatch.view.PathBuilder
import com.kenkoro.stopwatch.view.locals.Heights
import com.kenkoro.stopwatch.view.locals.LocalHeights
import com.kenkoro.stopwatch.view.locals.LocalPaddings
import com.kenkoro.stopwatch.view.locals.Paddings

@Composable
fun PathBuilderBox(
    modifier: Modifier = Modifier
) {
    val paddings = Paddings()
    val heights = Heights()
    val label = "Scrambler"

    CompositionLocalProvider(
        LocalHeights provides heights,
        LocalPaddings provides paddings
    ) {
        PathBuilder(
            modifier = modifier,
            padding = paddings.default,
            height = heights.medium,
            label = label
        )
    }
}