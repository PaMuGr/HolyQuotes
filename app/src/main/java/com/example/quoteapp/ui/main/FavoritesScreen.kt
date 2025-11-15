package com.example.quoteapp.ui.main

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.quoteapp.R

@Composable
fun FavoritesScreen(
    favoriteQuotes: Set<String>,
    onFavoriteToggle: (String) -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xffc2b294))
    ) {
        // Espacio arriba para bajar el header
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color(0xffc2b294))
        )

        // Header con color de las cartas - más pequeño
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color(0xFFf3dfc1))
                .padding(16.dp), // Padding normal
            contentAlignment = Alignment.Center
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Spacer(modifier = Modifier.height(20.dp)) // Espacio para bajar el texto
                Text(
                    stringResource(id = R.string.your_favorite_verses),
                    style = MaterialTheme.typography.titleMedium,
                    color = Color(0xFF6a6748),
                    fontWeight = FontWeight.Bold,
                    fontSize = 18.sp
                )
            }
        }

        Spacer(modifier = Modifier.height(16.dp)) // Menos espacio después del header

        if (favoriteQuotes.isEmpty()) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(32.dp),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    stringResource(id = R.string.no_favorites_yet),
                    textAlign = TextAlign.Center,
                    color = Color(0xFF6a6748),
                    style = MaterialTheme.typography.bodyLarge
                )
            }
        } else {
            LazyColumn(
                modifier = Modifier.padding(horizontal = 16.dp)
            ) {
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
@Composable
fun FavoriteQuoteItem(
    quote: String,
    onRemove: () -> Unit
) {
    Card(
        elevation = CardDefaults.cardElevation(4.dp),
        modifier = Modifier
            .fillMaxWidth()
            .height(140.dp),
        colors = CardDefaults.cardColors(containerColor = Color(0xFFf3dfc1))
    ) {
        Box(
            modifier = Modifier.fillMaxSize()
        ) {
            // Contenido del versículo
            Text(
                text = quote,
                modifier = Modifier
                    .fillMaxSize()
                    .padding(bottom = 50.dp)
                    .padding(16.dp),
                style = MaterialTheme.typography.bodyMedium,
                color = Color(0xFF6a6748),
                maxLines = 3,
                overflow = TextOverflow.Ellipsis
            )

            // Overlay de botones
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp)
                    .background(Color(0xFFe0c9a6))
                    .align(Alignment.BottomCenter)
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(horizontal = 16.dp),
                    horizontalArrangement = androidx.compose.foundation.layout.Arrangement.End,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    IconButton(
                        onClick = onRemove,
                        modifier = Modifier.size(40.dp)
                    ) {
                        Icon(
                            Icons.Default.Favorite,
                            stringResource(id = R.string.remove_from_favorites),
                            tint = Color(color = 0xFFae4d4e),
                            modifier = Modifier.size(28.dp)
                        )
                    }
                }
            }
        }
    }
}