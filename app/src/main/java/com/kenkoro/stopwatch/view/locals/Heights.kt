package com.kenkoro.stopwatch.view.locals

import androidx.compose.runtime.compositionLocalOf
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

data class Heights(
    val default: Dp = 50.dp,
    val small: Dp = 100.dp,
    val medium: Dp = 150.dp,
    val large: Dp = 300.dp,
    val extraLarge: Dp = 600.dp
)

val LocalHeights = compositionLocalOf { Heights() }