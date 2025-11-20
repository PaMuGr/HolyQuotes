package com.example.quoteapp.data

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.core.stringSetPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

//DATASTORE for APP preferences
private val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "settings")

class SettingsRepository(private val context: Context) {

    //--- Preference Keys ---
    private object PreferencesKeys {
        val IS_DARK_MODE = booleanPreferencesKey("is_dark_mode")
        val LANGUAGE = stringPreferencesKey("language")
        val FAVORITE_QUOTES = stringSetPreferencesKey("favorite_quotes")
    }

    //--- State Flows (Reading) ---

    val isDarkModeFlow: Flow<Boolean> = context.dataStore.data
        .map { preferences ->
            preferences[PreferencesKeys.IS_DARK_MODE] ?: false // Default to false (Light Mode)
        }

    val languageFlow: Flow<String> = context.dataStore.data
        .map { preferences ->
            preferences[PreferencesKeys.LANGUAGE] ?: "es" // Default to Spanish
        }

    val favoriteQuotesFlow: Flow<Set<String>> = context.dataStore.data
        .map { preferences ->
            preferences[PreferencesKeys.FAVORITE_QUOTES] ?: emptySet() // Default to empty set
        }


    //--- State Saving (Writing) ---

    suspend fun saveDarkModePreference(isDark: Boolean) {
        context.dataStore.edit { preferences ->
            preferences[PreferencesKeys.IS_DARK_MODE] = isDark
        }
    }

    suspend fun saveLanguagePreference(language: String) {
        context.dataStore.edit { preferences ->
            preferences[PreferencesKeys.LANGUAGE] = language
        }
    }

    suspend fun saveFavoriteQuotes(favorites: Set<String>) {
        context.dataStore.edit { preferences ->
            preferences[PreferencesKeys.FAVORITE_QUOTES] = favorites
        }
    }
}