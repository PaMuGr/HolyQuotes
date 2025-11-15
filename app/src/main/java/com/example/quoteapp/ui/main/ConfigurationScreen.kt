package com.example.quoteapp.ui.main

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.quoteapp.R
import com.example.quoteapp.ui.theme.CustomBackground

@Composable
fun ConfigurationScreen(
    isDarkMode: Boolean,
    language: String,
    onConfigurationChange: (Boolean, String) -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(CustomBackground)
    ) {
        // Header
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
                    stringResource(id = R.string.configuration),
                    style = MaterialTheme.typography.titleMedium,
                    color = Color(0xFF6a6748),
                    fontWeight = FontWeight.Bold,
                    fontSize = 18.sp
                )
            }
        }

        // Content
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(16.dp))

            // Dark/Light Mode
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(text = if (isDarkMode) stringResource(id = R.string.dark_mode) else stringResource(id = R.string.light_mode))
                Switch(
                    checked = isDarkMode,
                    onCheckedChange = { onConfigurationChange(it, language) }
                )
            }

            Spacer(modifier = Modifier.height(32.dp))

            // Language
            Text(text = stringResource(id = R.string.language))
            Spacer(modifier = Modifier.height(16.dp))
            Row {
                Button(onClick = { onConfigurationChange(isDarkMode, "en") }) {
                    Text(text = stringResource(id = R.string.english))
                }
                Spacer(modifier = Modifier.width(16.dp)) // Changed height to width
                Button(onClick = { onConfigurationChange(isDarkMode, "es") }) {
                    Text(text = stringResource(id = R.string.spanish))
                }
            }
        }
    }
}