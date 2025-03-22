package com.merteroglu286.kotlinogreniyorum.data.preferences

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.core.IOException
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.emptyPreferences
import androidx.datastore.preferences.preferencesDataStore
import com.merteroglu286.kotlinogreniyorum.domain.preferences.DataStoreOperations
import com.merteroglu286.kotlinogreniyorum.utility.Constants.APP_PREFERENCES
import com.merteroglu286.kotlinogreniyorum.utility.Constants.ON_BOARDING_PREFERENCES_KEY
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.map

val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = APP_PREFERENCES)

class DataStoreOperationsImpl(context: Context): DataStoreOperations{

    private object PreferencesKey{
        val onBoardingKey = booleanPreferencesKey(name = ON_BOARDING_PREFERENCES_KEY)
    }

    private val dataStore = context.dataStore

    override suspend fun saveOnBoardingState(isComplete: Boolean) {
        dataStore.edit { preferences ->
            preferences[PreferencesKey.onBoardingKey] = isComplete
        }
    }

    override fun readOnBoardingState(): Flow<Boolean> {
        return dataStore.data
            .catch { exception ->
                if (exception is IOException){
                    emit(emptyPreferences())
                } else {
                    throw exception
                }
            }
            .map { preferences ->
                val onBoardingState = preferences[PreferencesKey.onBoardingKey] ?: false
                onBoardingState
            }
    }
}