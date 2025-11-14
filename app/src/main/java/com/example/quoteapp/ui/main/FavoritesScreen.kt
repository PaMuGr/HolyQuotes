package com.example.quoteapp.ui.main

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp

@Composable
fun FavoritesScreen(
    favoriteQuotes: Set<String>,
    onFavoriteToggle: (String) -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text(
            "Tus Versículos Favoritos",
            modifier = Modifier.align(Alignment.CenterHorizontally),
            color = Color.White
        )

        Spacer(modifier = Modifier.height(24.dp))

        if (favoriteQuotes.isEmpty()) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(32.dp),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    "¡Aún no tienes favoritos!\nVe a la pestaña Versículos y toca el corazón ❤️",
                    textAlign = TextAlign.Center,
                    color = Color.White
                )
            }
        } else {
            LazyColumn {
                items(favoriteQuotes.toList()) { quote ->
                    FavoriteQuoteItem(
                        quote = quote,
                        onRemove = { onFavoriteToggle(quote) }
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                }
            }
        }
    }
}