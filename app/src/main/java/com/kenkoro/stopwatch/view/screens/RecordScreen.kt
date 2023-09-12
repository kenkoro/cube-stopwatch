package com.kenkoro.stopwatch.view.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.kenkoro.stopwatch.model.InternalRepository
import com.kenkoro.stopwatch.view.encapsulated.LazySolves
import com.kenkoro.stopwatch.view.locals.LocalPaddings
import com.kenkoro.stopwatch.view.locals.Paddings

@Composable
fun RecordScreen(
    modifier: Modifier = Modifier
) {
    val paddings = Paddings()
    val recordHistory = InternalRepository.allRecords()
    val dates = InternalRepository.allDates()

    CompositionLocalProvider(
        LocalPaddings provides paddings
    ) {
        LazyColumn(
            modifier = modifier
                .fillMaxSize()
                .background(MaterialTheme.colorScheme.primaryContainer),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            if (recordHistory.isEmpty()) {
                item {
                    EmptyRecordContent()
                }
            } else {
                items(recordHistory.size) {
                    LazySolves(
                        records = recordHistory[it],
                        date = dates[it],
                        paddings = paddings
                    )
                }
            }
        }
    }
}