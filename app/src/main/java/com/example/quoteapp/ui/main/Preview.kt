package com.example.quoteapp.ui.main

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.quoteapp.ui.theme.QuoteAppTheme

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    QuoteAppTheme {
        HelloApp(isDarkMode = false, language = "es", onConfigurationChange = { _, _ -> })
    }
}