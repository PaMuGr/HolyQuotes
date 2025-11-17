package com.example.quoteapp.ui.main

import android.content.res.Configuration
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalContext
import com.example.quoteapp.data.QuotesDataEn
import com.example.quoteapp.data.QuotesDataEs
import com.example.quoteapp.ui.theme.QuoteAppTheme
import java.util.Locale

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            var isDarkMode by remember { mutableStateOf(false) }
            var language by remember { mutableStateOf("es") } // Spanish by Default
            var selectedTabIndex by remember { mutableStateOf(0) }
            var favoriteQuotes by remember { mutableStateOf(setOf<String>()) }

            val quotes = remember(language) {
                when (language) {
                    "en" -> QuotesDataEn.quotes
                    "es" -> QuotesDataEs.quotes
                    else -> QuotesDataEs.quotes // Default option
                }
            }

            LocalizationWrapper(language = language) {
                QuoteAppTheme(darkTheme = isDarkMode) {
                    MainScreen(
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
                        },
                        isDarkMode = isDarkMode,
                        language = language,
                        onConfigurationChange = { newIsDarkMode, newLanguage ->
                            isDarkMode = newIsDarkMode
                            language = newLanguage
                        }
                    )
                }
            }
        }
    }
}

@Composable
fun LocalizationWrapper(
    language: String,
    content: @Composable () -> Unit
) {
    val locale = Locale.forLanguageTag(language)

    // Get the current configuration in a way Compose can track
    val baseConfiguration = LocalConfiguration.current
    val context = LocalContext.current

    // Recreate the context only when language or base config changes
    val localizedContext = remember(language, baseConfiguration) {
        // Create a copy of the configuration
        val configuration = Configuration(baseConfiguration)
        configuration.setLocale(locale)
        context.createConfigurationContext(configuration)
    }

    CompositionLocalProvider(LocalContext provides localizedContext, content = content)
}