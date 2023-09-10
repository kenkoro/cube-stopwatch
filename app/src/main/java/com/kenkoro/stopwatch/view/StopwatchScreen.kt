package com.kenkoro.stopwatch.view

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.width
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.kenkoro.stopwatch.model.Stopwatch
import com.kenkoro.stopwatch.model.StopwatchSaver
import com.kenkoro.stopwatch.view.heights.Heights
import com.kenkoro.stopwatch.view.heights.LocalHeights

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun StopwatchScreen(
    modifier: Modifier = Modifier,
    navController: NavController
) {
    val heights = Heights()
    Scaffold(
        modifier = modifier,
        containerColor = MaterialTheme.colorScheme.primaryContainer,
        contentColor = MaterialTheme.colorScheme.onPrimaryContainer,
        bottomBar = {
            BottomAppBar(
                containerColor = MaterialTheme.colorScheme.primaryContainer,
                contentColor = MaterialTheme.colorScheme.onPrimaryContainer
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Button(
                        modifier = Modifier.width(150.dp),
                        onClick = {
                            navController.navigate(Screen.RecordsScreen.route)
                        }
                    ) {
                        Text(text = "Records")
                    }
                }
            }
        }
    ) {
        Column(
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            CompositionLocalProvider(LocalHeights provides heights) {
                PathBuilderBox(
                    label = "BL'D'RU'D2L2D2R'DFB2UD'F2R2UD2R2U'", height = heights.medium
                )

                val stopwatch by rememberSaveable(stateSaver = StopwatchSaver.saver) {
                    mutableStateOf(Stopwatch())
                }
                StopwatchBox(
                    formattedTime = stopwatch.formattedTime,
                    stopwatch = stopwatch,
                    onStartClick = stopwatch::start,
                    onResetClick = stopwatch::reset,
                    onPauseClick = stopwatch::pause
                )
                StatsBox(height = heights.medium)
            }
        }
    }
}