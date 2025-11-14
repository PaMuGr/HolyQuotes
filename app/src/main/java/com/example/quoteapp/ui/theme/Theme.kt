package com.example.quoteapp.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val CustomColorScheme = lightColorScheme(
    primary = CustomPrimary,
    onPrimary = Color.White,
    surface = CustomSurface,
    onSurface = Color.Black,
    primaryContainer = CustomPrimary,
    onPrimaryContainer = Color.White
)

@Composable
fun QuoteAppTheme(content: @Composable () -> Unit) {
    MaterialTheme(
        colorScheme = CustomColorScheme,
        typography = Typography,
        content = content
    )
}