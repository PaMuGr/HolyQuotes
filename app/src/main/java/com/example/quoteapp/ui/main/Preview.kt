package com.example.quoteapp.ui.main

import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.runtime.Composable
import com.example.quoteapp.ui.theme.QuoteAppTheme

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    QuoteAppTheme {
        HelloApp()
    }
}