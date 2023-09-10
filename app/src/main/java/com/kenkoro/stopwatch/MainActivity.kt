package com.kenkoro.stopwatch

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.kenkoro.stopwatch.ui.theme.StopwatchTheme
import com.kenkoro.stopwatch.view.Navigation

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            StopwatchTheme {
                Navigation()
            }
        }
    }
}