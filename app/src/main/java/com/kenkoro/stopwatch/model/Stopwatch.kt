package com.kenkoro.stopwatch.model

import android.os.Build
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.cancel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import java.time.Instant
import java.time.LocalDateTime
import java.time.ZoneId
import java.time.format.DateTimeFormatter
import java.util.Locale

class Stopwatch {
    var formattedTime by mutableStateOf("00:00")

    private var coroutineScope = CoroutineScope(Dispatchers.Main)
    var isRunning = false

    private var timeMillis = 0L
    private var lastTimestamp = 0L

    fun start() {
        if (isRunning) return

        coroutineScope.launch {
            lastTimestamp = System.currentTimeMillis()
            isRunning = true
            while (isRunning) {
                delay(10)
                timeMillis += System.currentTimeMillis() - lastTimestamp
                lastTimestamp = System.currentTimeMillis()
                formattedTime = formatTime(timeMillis)
            }
        }
    }

    fun pause() {
        isRunning = false
    }

    fun reset() {
        coroutineScope.cancel()
        coroutineScope = CoroutineScope(Dispatchers.Main)
        timeMillis = 0L
        lastTimestamp = 0L
        formattedTime = "00:00"
        isRunning = false
    }

    private fun formatTime(timeMillis: Long): String {
        val localDateTime = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            LocalDateTime.ofInstant(
                Instant.ofEpochMilli(timeMillis),
                ZoneId.systemDefault()
            )
        } else {
            TODO("VERSION.SDK_INT < O")
        }
        val formatter = DateTimeFormatter.ofPattern(
            "ss:SS",
            Locale.getDefault()
        )

        return localDateTime.format(formatter)
    }
}