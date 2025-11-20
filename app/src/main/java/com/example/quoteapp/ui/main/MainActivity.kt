package com.example.quoteapp.ui.main

import android.content.res.Configuration
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalContext
import com.example.quoteapp.data.QuotesDataEn
import com.example.quoteapp.data.QuotesDataEs
import com.example.quoteapp.data.SettingsRepository
import com.example.quoteapp.ui.theme.QuoteAppTheme
import kotlinx.coroutines.launch
import java.util.Locale

class MainActivity : ComponentActivity() {
    //Initialize SettingsRepository
    private lateinit var settingsRepository: SettingsRepository

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        settingsRepository = SettingsRepository(applicationContext) // Initialize here

        enableEdgeToEdge()
        setContent {
            val repo = remember { settingsRepository }
            val scope = rememberCoroutineScope()
            val isDarkMode by repo.isDarkModeFlow.collectAsState(initial = false)
            val language by repo.languageFlow.collectAsState(initial = "es")
            val favoriteQuotes by repo.favoriteQuotesFlow.collectAsState(initial = setOf())
            var selectedTabIndex by remember { mutableIntStateOf(0) } //No change needed for tab index

            val quotes = remember(language) {
                when (language) {
                    "en" -> QuotesDataEn.quotes
                    "es" -> QuotesDataEs.quotes
                    else -> QuotesDataEs.quotes
                }
            }

            //For saving the data
            val onFavoriteToggle: (String) -> Unit = { quote ->
                scope.launch { //Save to datastore
                    val newFavorites = if (quote in favoriteQuotes) {
                        favoriteQuotes - quote
                    } else {
                        favoriteQuotes + quote
                    }
                    repo.saveFavoriteQuotes(newFavorites)
                }
            }

            val onConfigurationChange: (Boolean, String) -> Unit = { newIsDarkMode, newLanguage ->
                scope.launch { //Save to datastore
                    repo.saveDarkModePreference(newIsDarkMode)
                    repo.saveLanguagePreference(newLanguage)
                }
            }


            LocalizationWrapper(language = language) {
                QuoteAppTheme(darkTheme = isDarkMode) {
                    MainScreen(
                        selectedTabIndex = selectedTabIndex,
                        onTabSelected = { selectedTabIndex = it },
                        quotes = quotes,
                        favoriteQuotes = favoriteQuotes,
                        onFavoriteToggle = onFavoriteToggle,
                        isDarkMode = isDarkMode,
                        language = language,
                        onConfigurationChange = onConfigurationChange
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
    val baseConfiguration = LocalConfiguration.current
    val context = LocalContext.current

    val localizedContext = remember(language, baseConfiguration) {
        val configuration = Configuration(baseConfiguration)
        configuration.setLocale(locale)
        context.createConfigurationContext(configuration)
    }

    CompositionLocalProvider(LocalContext provides localizedContext, content = content)
}