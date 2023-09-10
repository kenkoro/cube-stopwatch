package com.kenkoro.stopwatch.model

import androidx.compose.runtime.saveable.listSaver

object StopwatchSaver {
    val saver = listSaver<Stopwatch, Any>(
        save = {
            listOf(
                it.formattedTime,
                it.timeMillis,
                it.lastTimestamp,
            )
        },
        restore = {
            Stopwatch().apply {
                formattedTime = it[0] as String
                isRunning = false
                timeMillis = it[1] as Long
                lastTimestamp = it[2] as Long
            }
        }
    )
}