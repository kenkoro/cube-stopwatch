package com.kenkoro.stopwatch

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import com.kenkoro.stopwatch.ui.theme.StopwatchTheme
import com.kenkoro.stopwatch.view.Stopwatch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            StopwatchTheme {
                Stopwatch(
                    modifier = Modifier
                        .fillMaxSize()
                )
            }
        }
    }
}