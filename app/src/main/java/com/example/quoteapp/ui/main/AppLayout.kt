package com.example.quoteapp.ui.main

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.quoteapp.ui.theme.CustomBackground
import com.example.quoteapp.ui.theme.CustomPrimary

@Composable
fun AppLayout(
    selectedTabIndex: Int,
    onTabSelected: (Int) -> Unit,
    quotes: List<String>,
    favoriteQuotes: Set<String>,
    onFavoriteToggle: (String) -> Unit
) {
    Surface(
        color = Color.Transparent,
        modifier = Modifier.fillMaxSize()
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(CustomBackground)
        ) {
            // Content Area (takes most space)
            Box(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxSize()
            ) {
                when (selectedTabIndex) {
                    0 -> QuotesScreen(
                        quotes = quotes,
                        favoriteQuotes = favoriteQuotes,
                        onFavoriteToggle = onFavoriteToggle
                    )
                    1 -> FavoritesScreen(
                        favoriteQuotes = favoriteQuotes,
                        onFavoriteToggle = onFavoriteToggle
                    )
                }
            }

            // Custom Bottom Navigation with card color
            CustomBottomNavigation(
                selectedTabIndex = selectedTabIndex,
                onTabSelected = onTabSelected
            )
        }
    }
}

@Composable
fun CustomBottomNavigation(
    selectedTabIndex: Int,
    onTabSelected: (Int) -> Unit
) {
    val tabs = listOf("Versículos", "Favoritos")

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color(0xFFf3dfc1)) // Color de las tarjetas
    ) {
        // Top indicator line - RED LINE ON TOP
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(3.dp)
        ) {
            // Animated red line
            Box(
                modifier = Modifier
                    .height(3.dp)
                    .fillMaxWidth(0.5f) // 50% width for each tab
                    .background(CustomPrimary)
                    .align(
                        when (selectedTabIndex) {
                            0 -> Alignment.TopStart
                            1 -> Alignment.TopEnd
                            else -> Alignment.TopStart
                        }
                    )
            )
        }

        // Tabs Row - CLICKABLE
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(70.dp)
                .padding(horizontal = 16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            tabs.forEachIndexed { index, title ->
                Box(
                    modifier = Modifier
                        .weight(1f)
                        .height(60.dp)
                        .padding(4.dp)
                        .background(Color.Transparent)
                        .clickable { onTabSelected(index) },
                    contentAlignment = Alignment.Center
                ) {
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = androidx.compose.foundation.layout.Arrangement.Center
                    ) {
                        Text(
                            text = title,
                            color = if (selectedTabIndex == index) CustomPrimary else Color(0xFF6a6748),
                            fontSize = 16.sp,
                            fontWeight = if (selectedTabIndex == index) FontWeight.Bold else FontWeight.Medium
                        )
                    }
                }

                // Add spacer between tabs except for last one
                if (index < tabs.size - 1) {
                    Spacer(modifier = Modifier.width(8.dp))
                }
            }
        }

        // Additional spacer for system navigation
        Spacer(modifier = Modifier.height(8.dp))
    }
}