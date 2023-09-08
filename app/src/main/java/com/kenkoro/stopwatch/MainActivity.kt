@file:OptIn(ExperimentalMaterial3Api::class)

package com.kenkoro.stopwatch

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
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

@Preview
@Composable
fun Prev() {
    StopwatchTheme {
        Navigation()
    }
}