package com.kenkoro.stopwatch.view.encapsulated

import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Modifier
import com.kenkoro.stopwatch.view.Scrambler
import com.kenkoro.stopwatch.view.locals.Heights
import com.kenkoro.stopwatch.view.locals.LocalHeights
import com.kenkoro.stopwatch.view.locals.LocalPaddings
import com.kenkoro.stopwatch.view.locals.Paddings

@Composable
fun ScramblerBox(
    modifier: Modifier = Modifier,
    label: String
) {
    val paddings = Paddings()
    val heights = Heights()

    CompositionLocalProvider(
        LocalHeights provides heights,
        LocalPaddings provides paddings
    ) {
        Scrambler(
            modifier = modifier,
            padding = paddings.default,
            height = heights.medium,
            label = label
        )
    }
}