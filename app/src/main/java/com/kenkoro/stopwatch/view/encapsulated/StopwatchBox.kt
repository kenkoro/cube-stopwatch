package com.kenkoro.stopwatch.view.encapsulated

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.hapticfeedback.HapticFeedbackType
import androidx.compose.ui.platform.LocalHapticFeedback
import com.kenkoro.stopwatch.model.InternalRepository
import com.kenkoro.stopwatch.model.ScramblerBuilder
import com.kenkoro.stopwatch.model.Stopwatch
import com.kenkoro.stopwatch.model.StopwatchSaver
import com.kenkoro.stopwatch.view.StopwatchUi
import com.kenkoro.stopwatch.view.locals.LocalPaddings
import com.kenkoro.stopwatch.view.locals.Paddings

@Composable
fun StopwatchBox(
    modifier: Modifier = Modifier,
    onLabelChange: (newLabel: String) -> Unit
) {
    val haptic = LocalHapticFeedback.current
    val paddings = Paddings()
    val stopwatch by rememberSaveable(stateSaver = StopwatchSaver.saver) {
        mutableStateOf(Stopwatch())
    }

    CompositionLocalProvider(
        LocalPaddings provides paddings
    ) {
        StopwatchUi(
            modifier = modifier,
            padding = paddings.default,
            formattedTime = stopwatch.formattedTime,
            onClick = {
                haptic.performHapticFeedback(HapticFeedbackType.LongPress)
                if (stopwatch.isRunning) {
                    stopwatch.pause()
                    InternalRepository.saveRecord(stopwatch.formattedTime)
                } else {
                    when (stopwatch.formattedTime) {
                        "00:00" -> stopwatch.start()
                        else -> {
                            stopwatch.reset()
                            onLabelChange(ScramblerBuilder.generate())
                        }
                    }
                }
            }
        )
    }
}