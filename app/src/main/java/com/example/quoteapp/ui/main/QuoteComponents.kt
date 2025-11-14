package com.example.quoteapp.ui.main

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.example.quoteapp.ui.theme.CustomOverlay
import com.example.quoteapp.ui.theme.CustomSurface
import androidx.compose.foundation.background

@Composable
fun QuoteCard(
    quote: String,
    isFavorite: Boolean,
    onFavoriteToggle: () -> Unit,
    onShare: () -> Unit
) {
    Card(
        elevation = CardDefaults.cardElevation(8.dp),
        modifier = Modifier
            .fillMaxWidth(0.9f)
            .height(400.dp),
        colors = CardDefaults.cardColors(containerColor = CustomSurface)
    ) {
        Box(
            modifier = Modifier.fillMaxSize()
        ) {
            // Contenido principal del versículo
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(bottom = 60.dp),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = quote,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.padding(24.dp)
                )
            }

            // Overlay de botones
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(60.dp)
                    .background(CustomOverlay)
                    .align(Alignment.BottomCenter)
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(horizontal = 24.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    // Like button
                    IconButton(
                        onClick = onFavoriteToggle,
                        modifier = Modifier.size(48.dp)
                    ) {
                        Icon(
                            Icons.Default.Favorite,
                            "Agregar a favoritos",
                            tint = if (isFavorite) Color.Red else Color(0xFF6a6748),
                            modifier = Modifier.size(32.dp)
                        )
                    }

                    // Share button
                    IconButton(
                        onClick = onShare,
                        modifier = Modifier.size(48.dp)
                    ) {
                        Icon(
                            Icons.Default.Share,
                            "Compartir versículo",
                            tint = Color(0xFF6a6748),
                            modifier = Modifier.size(32.dp)
                        )
                    }
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
            .padding(horizontal = 8.dp)
            .height(140.dp),
        colors = CardDefaults.cardColors(containerColor = CustomSurface)
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
                maxLines = 3,
                overflow = TextOverflow.Ellipsis
            )

            // Overlay de botones
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp)
                    .background(CustomOverlay)
                    .align(Alignment.BottomCenter)
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(horizontal = 16.dp),
                    horizontalArrangement = Arrangement.End,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    IconButton(
                        onClick = onRemove,
                        modifier = Modifier.size(40.dp)
                    ) {
                        Icon(
                            Icons.Default.Favorite,
                            "Eliminar de favoritos",
                            tint = Color.Red,
                            modifier = Modifier.size(28.dp)
                        )
                    }
                }
            }
        }
    }
}