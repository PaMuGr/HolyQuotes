package com.example.quoteapp.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val LightColorScheme = lightColorScheme(
    primary = CustomPrimary,
    onPrimary = Color.White,
    surface = CustomSurface,
    onSurface = CustomTextColor,
    background = CustomBackground,
    onBackground = CustomTextColor
)

private val DarkColorScheme = darkColorScheme(
    primary = CustomPrimary,
    onPrimary = Color.White,
    surface = Color.Black,
    onSurface = Color.White,
    background = Color.DarkGray,
    onBackground = Color.White
)

@Composable
fun QuoteAppTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colorScheme = if (darkTheme) {
        DarkColorScheme
    } else {
        LightColorScheme
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}