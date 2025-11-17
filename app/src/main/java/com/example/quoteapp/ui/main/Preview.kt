package com.example.quoteapp.ui.main

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.quoteapp.ui.theme.QuoteAppTheme

// Dades de mostra reals (copiades de MainActivity.kt)
val sampleQuotesList = listOf(
    "The Lord is my shepherd, I shall not want.",
    "For God so loved the world that he gave his one and only Son.",
    "I can do all things through Christ who strengthens me."
)

@Preview(showBackground = true, name = "Light Mode - Verses")
@Composable
fun DefaultPreview() {
    QuoteAppTheme {
        MainScreen(
            selectedTabIndex = 0,
            onTabSelected = {},
            quotes = sampleQuotesList, // <-- CANVI AQUÍ
            favoriteQuotes = setOf(sampleQuotesList[1]), // Mostra un favorit
            onFavoriteToggle = {},
            isDarkMode = false,
            language = "es",
            onConfigurationChange = { _, _ -> },
            onNavigateToLanguage = {}
        )
    }
}

@Preview(showBackground = true, name = "Dark Mode - Verses")
@Composable
fun DarkModePreview() {
    QuoteAppTheme(darkTheme = true) {
        MainScreen(
            selectedTabIndex = 0,
            onTabSelected = {},
            quotes = sampleQuotesList, // <-- CANVI AQUÍ
            favoriteQuotes = setOf(sampleQuotesList[1]), // Mostra un favorit
            onFavoriteToggle = {},
            isDarkMode = true,
            language = "es",
            onConfigurationChange = { _, _ -> },
            onNavigateToLanguage = {}
        )
    }
}

@Preview(showBackground = true, name = "Light Mode - Favorites")
@Composable
fun FavoritesPreview() {
    QuoteAppTheme {
        MainScreen(
            selectedTabIndex = 1,
            onTabSelected = {},
            quotes = sampleQuotesList, // <-- CANVI AQUÍ
            favoriteQuotes = setOf(sampleQuotesList[1]), // Mostra un favorit
            onFavoriteToggle = {},
            isDarkMode = false,
            language = "es",
            onConfigurationChange = { _, _ -> },
            onNavigateToLanguage = {}
        )
    }
}

@Preview(showBackground = true, name = "Light Mode - Settings")
@Composable
fun SettingsPreview() {
    QuoteAppTheme {
        MainScreen(
            selectedTabIndex = 2,
            onTabSelected = {},
            quotes = sampleQuotesList, // <-- CANVI AQUÍ
            favoriteQuotes = setOf(),
            onFavoriteToggle = {},
            isDarkMode = false,
            language = "es",
            onConfigurationChange = { _, _ -> },
            onNavigateToLanguage = {}
        )
    }
}