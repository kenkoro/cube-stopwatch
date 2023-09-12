package com.kenkoro.stopwatch.view.bars

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardDoubleArrowRight
import androidx.compose.material.icons.filled.WatchLater
import androidx.compose.material.icons.outlined.KeyboardDoubleArrowRight
import androidx.compose.material.icons.outlined.WatchLater
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun BottomBarHost(
    modifier: Modifier = Modifier,
    content: @Composable (index: Int) -> Unit
) {
    val tabItems = listOf(
        TabItem(
            title = "Stopwatch",
            unselectedIcon = Icons.Outlined.WatchLater,
            selectedIcon = Icons.Filled.WatchLater
        ),
        TabItem(
            title = "Solves",
            unselectedIcon = Icons.Outlined.KeyboardDoubleArrowRight,
            selectedIcon = Icons.Filled.KeyboardDoubleArrowRight
        )
    )

    val pagerState = rememberPagerState {
        tabItems.size
    }

    BottomBarWithContent(
        modifier = modifier,
        tabItems = tabItems,
        pagerState = pagerState
    ) { index ->
        content(index)
    }
}