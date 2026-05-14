package com.example.cryptotracker.data

import android.content.Context
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

// Krijojmë një "depo" të vogël për të dhënat
private val Context.dataStore by preferencesDataStore(name = "settings")

class SettingsManager(private val context: Context) {

    // Çelësi për të ruajtur Dark Mode (True/False)
    companion object {
        val DARK_MODE_KEY = booleanPreferencesKey("dark_mode")
    }

    // 1. Funksion për të ruajtur zgjedhjen
    suspend fun setDarkMode(enabled: Boolean) {
        context.dataStore.edit { preferences ->
            preferences[DARK_MODE_KEY] = enabled
        }
    }

    // 2. Flow për të lexuar zgjedhjen (Live)
    val isDarkMode: Flow<Boolean> = context.dataStore.data
        .map { preferences ->
            preferences[DARK_MODE_KEY] ?: false // Default është False (Light Mode)
        }
}