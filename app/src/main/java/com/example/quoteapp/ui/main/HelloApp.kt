package com.example.quoteapp.ui.main

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import com.example.quoteapp.repository.QuoteRepository

@Composable
fun HelloApp() {
    val repository = QuoteRepository()
    val quotes = remember { repository.getAllQuoteTexts() }
    var favoriteQuotes by remember { mutableStateOf(setOf<String>()) }
    var selectedTabIndex by remember { mutableIntStateOf(0) }

    AppLayout(
        selectedTabIndex = selectedTabIndex,
        onTabSelected = { selectedTabIndex = it },
        quotes = quotes,
        favoriteQuotes = favoriteQuotes,
        onFavoriteToggle = { quote ->
            favoriteQuotes = if (quote in favoriteQuotes) {
                favoriteQuotes - quote
            } else {
                favoriteQuotes + quote
            }
        }
    )
}