package com.example.quoteapp.ui.main

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.VerticalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.quoteapp.utils.shareQuote

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun QuotesScreen(
    quotes: List<String>,
    favoriteQuotes: Set<String>,
    onFavoriteToggle: (String) -> Unit
) {
    val context = LocalContext.current

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xffc2b294))
    ) {
        // Header HolyQuotes by PaMuGr - texto más abajo
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color(0xFFf3dfc1))
                .padding(16.dp),
            contentAlignment = Alignment.Center
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Spacer(modifier = Modifier.height(20.dp))
                Text(
                    "HolyQuotes de PaMuGr",
                    style = MaterialTheme.typography.titleMedium,
                    color = Color(0xFF6a6748),
                    fontWeight = FontWeight.Bold,
                    fontSize = 18.sp
                )
            }
        }

        val pagerState = rememberPagerState(pageCount = { quotes.size })

        // LazyColumn mejorado para efecto tipo Reels
        VerticalPager(
            state = pagerState,
            modifier = Modifier
                .weight(1f)
                .fillMaxWidth()
        ) { page ->
            val quote = quotes[page]
            // Container que fuerza el tamaño de pantalla completa
            Box(
                modifier = Modifier
                    .fillMaxSize() // Esto hace que cada item ocupe el viewport completo
                    .background(Color(0xffc2b294)),
                contentAlignment = Alignment.Center
            ) {
                // Contenido centrado verticalmente
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    QuoteCard(
                        quote = quote,
                        isFavorite = quote in favoriteQuotes,
                        onFavoriteToggle = { onFavoriteToggle(quote) },
                        onShare = { shareQuote(context, quote) },
                        modifier = Modifier
                            .fillMaxWidth(0.9f)
                            .height(400.dp)
                    )
                }
            }
        }
    }
}