package com.example.quoteapp.ui.main

import android.content.Context
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
import androidx.compose.ui.platform.LocalContext
import com.example.quoteapp.ui.theme.QuoteAppTheme
import java.util.Locale

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            var isDarkMode by remember { mutableStateOf(false) }
            var language by remember { mutableStateOf("en") } // Default to Spanish

            LocalizationWrapper(language = language) {
                QuoteAppTheme(darkTheme = isDarkMode) {
                    HelloApp(isDarkMode, language) { newIsDarkMode, newLanguage ->
                        isDarkMode = newIsDarkMode
                        language = newLanguage
                    }
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
    val context = LocalContext.current

    val localizedContext = remember(language) {
        val configuration = Configuration(context.resources.configuration)
        configuration.setLocale(locale)
        context.createConfigurationContext(configuration)
    }

    CompositionLocalProvider(LocalContext provides localizedContext, content = content)
}