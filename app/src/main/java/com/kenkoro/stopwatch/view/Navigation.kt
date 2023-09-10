package com.kenkoro.stopwatch.view

import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.kenkoro.stopwatch.view.locals.LocalPaddings
import com.kenkoro.stopwatch.view.locals.Paddings
import com.kenkoro.stopwatch.view.screens.RecordsScreen
import com.kenkoro.stopwatch.view.screens.StopwatchScreen
import com.kenkoro.stopwatch.view.sealed.Screen

@Composable
fun Navigation() {
    val navController = rememberNavController()
    val paddings = Paddings()
    NavHost(navController = navController, startDestination = Screen.StopwatchScreen.route) {
        composable(route = Screen.StopwatchScreen.route) {
            StopwatchScreen(navController = navController)
        }
        composable(route = Screen.RecordsScreen.route) {
            CompositionLocalProvider(
                LocalPaddings provides paddings
            ) {
                RecordsScreen(navController = navController, padding = paddings.default)
            }
        }
    }
}