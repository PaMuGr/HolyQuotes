package com.example.quoteapp.ui.main

import androidx.compose.foundation.gestures.detectHorizontalDragGestures
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.input.pointer.pointerInput
import com.example.quoteapp.utils.shareQuote

@Composable
fun QuotesScreen(
    quotes: List<String>,
    favoriteQuotes: Set<String>,
    onFavoriteToggle: (String) -> Unit
) {
    var currentQuoteIndex by remember { mutableIntStateOf(0) }
    val currentQuote = quotes[currentQuoteIndex]

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .pointerInput(Unit) {
                detectHorizontalDragGestures { _, dragAmount ->
                    when {
                        dragAmount > 50 -> { // Swipe right
                            currentQuoteIndex = (currentQuoteIndex - 1 + quotes.size) % quotes.size
                        }
                        dragAmount < -50 -> { // Swipe left
                            currentQuoteIndex = (currentQuoteIndex + 1) % quotes.size
                        }
                    }
                }
            },
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(32.dp))

        // Swipe Indicator
        Text(
            "Desliza izquierda/derecha para más versículos",
            color = Color.White,
            modifier = Modifier.padding(bottom = 16.dp)
        )

        // Quote Card
        val context = LocalContext.current
        QuoteCard(
            quote = currentQuote,
            isFavorite = currentQuote in favoriteQuotes,
            onFavoriteToggle = { onFavoriteToggle(currentQuote) },
            onShare = {
                shareQuote(context, currentQuote)
            }
        )

        Spacer(modifier = Modifier.height(32.dp))

        // Quote Counter
        Text(
            "${currentQuoteIndex + 1}/${quotes.size}",
            color = Color.White
        )
    }
}