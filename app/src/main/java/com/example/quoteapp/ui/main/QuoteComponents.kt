package com.example.quoteapp.ui.main

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.widthIn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.quoteapp.R
import com.example.quoteapp.ui.theme.FavoriteRed

@Composable
fun QuoteCard(
    quote: String,
    isFavorite: Boolean,
    onFavoriteToggle: () -> Unit,
    onShare: () -> Unit,
    modifier: Modifier = Modifier
) {
    Card(
        elevation = CardDefaults.cardElevation(8.dp),
        modifier = modifier,
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface)
    ) {
        Box(
            modifier = Modifier.fillMaxSize()
        ) {
            // Main verse content
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(bottom = 60.dp),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = quote,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.padding(24.dp).widthIn(max = 500.dp),
                    color = MaterialTheme.colorScheme.onSurface
                )
            }

            // Button overlay
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(60.dp)
                    .background(MaterialTheme.colorScheme.surfaceVariant)
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
                            stringResource(id = R.string.add_to_favorites),
                            tint = if (isFavorite) FavoriteRed else MaterialTheme.colorScheme.onSurfaceVariant,
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
                            stringResource(id = R.string.share_verse),
                            tint = MaterialTheme.colorScheme.onSurfaceVariant,
                            modifier = Modifier.size(32.dp)
                        )
                    }
                }
            }
        }
    }
}