package com.kenkoro.stopwatch.view.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.kenkoro.stopwatch.view.bars.BottomBar
import com.kenkoro.stopwatch.view.encapsulated.ScramblerAndStopwatch
import com.kenkoro.stopwatch.view.encapsulated.StatsBox

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun StopwatchScreen(
    modifier: Modifier = Modifier,
    navController: NavController
) {
    Scaffold(
        modifier = modifier,
        containerColor = MaterialTheme.colorScheme.primaryContainer,
        contentColor = MaterialTheme.colorScheme.onPrimaryContainer,
        bottomBar = { BottomBar(navController = navController) }
    ) {
        Column(
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            ScramblerAndStopwatch()
            StatsBox()
        }
    }
}