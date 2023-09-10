package com.kenkoro.stopwatch.view.locals

import androidx.compose.runtime.compositionLocalOf
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

data class Paddings(
    val default: Dp = 10.dp,
    val small: Dp = 5.dp,
    val medium: Dp = 15.dp,
    val large: Dp = 25.dp,
    val extraLarge: Dp = 30.dp
)

val LocalPaddings = compositionLocalOf { Paddings() }