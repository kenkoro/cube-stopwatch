package com.kenkoro.stopwatch.view

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun Navigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Screen.StopwatchScreen.route) {
        composable(route = Screen.StopwatchScreen.route) {
            StopwatchScreen(navController = navController)
        }
        composable(route = Screen.RecordsScreen.route) {
            RecordsScreen(navController = navController)
        }
    }
}