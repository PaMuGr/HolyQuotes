package com.example.quoteapp.ui.main

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.quoteapp.R
import java.util.Locale

@Composable
fun ConfigurationScreen(
    isDarkMode: Boolean,
    language: String,
    onConfigurationChange: (Boolean, String) -> Unit,
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
    ) {
        // Header (sense canvis)
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(MaterialTheme.colorScheme.surface)
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
                    color = MaterialTheme.colorScheme.onSurface,
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
        ) {
            // Language and Theme Section
            SettingsGroup(title = stringResource(R.string.settings)) {
                // Dark/Light Mode (sense canvis)
                SettingsRow(label = if (isDarkMode) stringResource(id = R.string.dark_mode) else stringResource(id = R.string.light_mode)) {
                    Switch(
                        checked = isDarkMode,
                        onCheckedChange = { onConfigurationChange(it, language) }
                    )
                }

                // --- SECCIÓ D'IDIOMA MODIFICADA ---

                // Títol per a la secció d'idioma
                Text(
                    text = stringResource(id = R.string.language),
                    style = MaterialTheme.typography.bodyLarge,
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.onSurface,
                    modifier = Modifier.padding(vertical = 8.dp)
                )

                // Botó/Fila per Espanyol
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clickable { onConfigurationChange(isDarkMode, "es") } // Canvia a 'es'
                        .padding(vertical = 12.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "Español",
                        color = if (language == "es") MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.onSurface,
                        fontWeight = if (language == "es") FontWeight.Bold else FontWeight.Normal,
                        style = MaterialTheme.typography.bodyLarge
                    )
                }

                // Botó/Fila per Anglès
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clickable { onConfigurationChange(isDarkMode, "en") } // Canvia a 'en'
                        .padding(vertical = 12.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "English",
                        color = if (language == "en") MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.onSurface,
                        fontWeight = if (language == "en") FontWeight.Bold else FontWeight.Normal,
                        style = MaterialTheme.typography.bodyLarge
                    )
                }
                // --- FI DE LA SECCIÓ MODIFICADA ---
            }

            Spacer(modifier = Modifier.height(16.dp))

            // Notifications Section (sense canvis)
            SettingsGroup(title = stringResource(id = R.string.notifications)) {
                SettingsRow(label = stringResource(id = R.string.activate_notifications)) {
                    Switch(checked = false, onCheckedChange = {})
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            // Support Section (sense canvis)
            SettingsGroup(title = stringResource(id = R.string.support)) {
                SettingsRow(label = stringResource(id = R.string.help)) { }
                SettingsRow(label = stringResource(id = R.string.report_bugs)) { }
            }
        }
    }
}

// SettingsGroup (sense canvis)
@Composable
fun SettingsGroup(title: String, content: @Composable ColumnScope.() -> Unit) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        elevation = CardDefaults.cardElevation(2.dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(
                text = title,
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.primary
            )
            Spacer(modifier = Modifier.height(8.dp))
            content()
        }
    }
}

// SettingsRow (sense canvis)
@Composable
fun SettingsRow(label: String, content: @Composable () -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(text = label, style = MaterialTheme.typography.bodyLarge, color = MaterialTheme.colorScheme.onSurface)
        content()
    }
}