package com.kenkoro.stopwatch.view.encapsulated

import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import com.kenkoro.stopwatch.model.InternalRepository
import com.kenkoro.stopwatch.view.Stats
import com.kenkoro.stopwatch.view.locals.Heights
import com.kenkoro.stopwatch.view.locals.LocalHeights
import com.kenkoro.stopwatch.view.locals.Paddings
import java.io.File

@Composable
fun StatsBox(
    modifier: Modifier = Modifier
) {
    val context = LocalContext.current
    fun configRepository() {
        val path = context.filesDir
        val directory = File(path, "records")
        directory.mkdir()
        InternalRepository.configDirectory(directory)
    }

    val paddings = Paddings()
    val heights = Heights()
    configRepository()
    val recordHistory = InternalRepository.allRecords()
    var solves by remember {
        mutableStateOf("-")
    }
    val repository by remember {
        mutableStateOf(InternalRepository)
    }

    fun calculate() {
        var count = 0
        recordHistory.forEach {
            val records = it.split("\n")
            count += records.count()
        }
        solves = if (count != 0) count.toString() else "-"
    }

    LaunchedEffect(repository) {
        calculate()
    }
    val stats = listOf(
        "Solves: $solves",
    )

    CompositionLocalProvider(
        LocalHeights provides heights
    ) {
        Stats(
            modifier = modifier,
            height = heights.medium,
            paddings = paddings,
            stats = stats
        )
    }
}
