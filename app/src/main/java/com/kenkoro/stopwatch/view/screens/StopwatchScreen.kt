package com.kenkoro.stopwatch.view.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import com.kenkoro.stopwatch.model.InternalRepository
import com.kenkoro.stopwatch.view.encapsulated.ScramblerAndStopwatch
import com.kenkoro.stopwatch.view.encapsulated.StatsBox
import java.io.File

@Composable
fun StopwatchScreen(
    modifier: Modifier = Modifier
) {
    val context = LocalContext.current
    LaunchedEffect(true) {
        val path = context.filesDir
        val directory = File(path, "records")
        directory.mkdir()
        InternalRepository.configDirectory(directory)
    }

    Column(
        modifier = modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.primaryContainer),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        ScramblerAndStopwatch()
        StatsBox()
    }
}