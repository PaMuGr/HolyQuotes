package com.example.quoteapp.ui.main

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Surface
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.example.quoteapp.ui.theme.CustomBackground

@Composable
fun AppLayout(
    selectedTabIndex: Int,
    onTabSelected: (Int) -> Unit,
    quotes: List<String>,
    favoriteQuotes: Set<String>,
    onFavoriteToggle: (String) -> Unit
) {
    Surface(
        color = Color.Transparent,
        modifier = Modifier.fillMaxSize()
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(CustomBackground)
        ) {
            Column(
                modifier = Modifier.fillMaxSize()
            ) {
                // Tab Navigation
                val tabTitles = listOf("Versículos", "Favoritos")
                TabRow(
                    selectedTabIndex = selectedTabIndex,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    tabTitles.forEachIndexed { index, title ->
                        Tab(
                            text = { Text(title) },
                            selected = selectedTabIndex == index,
                            onClick = { onTabSelected(index) }
                        )
                    }
                }

                // Pages
                when (selectedTabIndex) {
                    0 -> QuotesScreen(
                        quotes = quotes,
                        favoriteQuotes = favoriteQuotes,
                        onFavoriteToggle = onFavoriteToggle
                    )
                    1 -> FavoritesScreen(
                        favoriteQuotes = favoriteQuotes,
                        onFavoriteToggle = onFavoriteToggle
                    )
                }
            }
        }
    }
}