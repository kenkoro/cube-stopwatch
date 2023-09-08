package com.kenkoro.stopwatch.view

sealed class Screen(val route: String) {
    object StopwatchScreen : Screen("stopwatch_screen")
    object RecordsScreen : Screen("records_screen")
}
