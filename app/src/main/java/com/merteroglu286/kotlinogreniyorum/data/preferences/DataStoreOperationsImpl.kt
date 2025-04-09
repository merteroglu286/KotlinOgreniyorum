package com.merteroglu286.kotlinogreniyorum.data.preferences

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.core.IOException
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.emptyPreferences
import androidx.datastore.preferences.core.floatPreferencesKey
import androidx.datastore.preferences.core.intPreferencesKey
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.merteroglu286.kotlinogreniyorum.domain.preferences.DataStoreOperations
import com.merteroglu286.kotlinogreniyorum.utility.PreferencesKeys.APP_PREFERENCES
import com.merteroglu286.kotlinogreniyorum.utility.PreferencesKeys.COMPLETED_QUESTIONS_KEY
import com.merteroglu286.kotlinogreniyorum.utility.PreferencesKeys.COMPLETED_TOPICS_KEY
import com.merteroglu286.kotlinogreniyorum.utility.PreferencesKeys.MODULE_COUNT_KEY
import com.merteroglu286.kotlinogreniyorum.utility.PreferencesKeys.ON_BOARDING_PREFERENCES_KEY
import com.merteroglu286.kotlinogreniyorum.utility.PreferencesKeys.PROGRESS_KEY
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.map

val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = APP_PREFERENCES)

class DataStoreOperationsImpl(context: Context) : DataStoreOperations {

    private object PreferencesKey {
        val onBoardingKey = booleanPreferencesKey(name = ON_BOARDING_PREFERENCES_KEY)
        val moduleCountKey = intPreferencesKey(name = MODULE_COUNT_KEY)
        val completedTopicsKey = stringPreferencesKey(name = COMPLETED_TOPICS_KEY)
        val completedQuestionsKey = stringPreferencesKey(name = COMPLETED_QUESTIONS_KEY)
        val progressKey = floatPreferencesKey(name = PROGRESS_KEY)
    }

    private val dataStore = context.dataStore
    private val gson = Gson()

    override suspend fun saveOnBoardingState(isComplete: Boolean) {
        dataStore.edit { preferences ->
            preferences[PreferencesKey.onBoardingKey] = isComplete
        }
    }

    override fun readOnBoardingState(): Flow<Boolean> {
        return dataStore.data
            .catch { exception ->
                if (exception is IOException) {
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

    override suspend fun saveModuleCount(count: Int) {
        dataStore.edit { preferences ->
            preferences[PreferencesKey.moduleCountKey] = count
        }
    }

    override fun readModuleCount(): Flow<Int> {
        return dataStore.data
            .catch { exception ->
                if (exception is IOException) {
                    emit(emptyPreferences())
                } else {
                    throw exception
                }
            }
            .map { preferences ->
                val moduleCount = preferences[PreferencesKey.moduleCountKey] ?: 0
                moduleCount
            }
    }

    override suspend fun saveProgress(progress: Float) {
        dataStore.edit { preferences ->
            preferences[PreferencesKey.progressKey] = progress
        }
    }

    override fun readProgress(): Flow<Float> {
        return dataStore.data
            .catch { exception ->
                if (exception is IOException) {
                    emit(emptyPreferences())
                } else {
                    throw exception
                }
            }
            .map { preferences ->
                val progress = preferences[PreferencesKey.progressKey] ?: 0f
                progress
            }
    }

    override suspend fun saveModuleIdToListForTopic(moduleId: Int) {
        dataStore.edit { preferences ->
            val currentList = preferences[PreferencesKey.completedTopicsKey]?.let {
                runCatching { gson.fromJson<List<Int>>(it, object : TypeToken<List<Int>>() {}.type) }
                    .getOrDefault(emptyList())
            } ?: emptyList()

            val updatedList = if (moduleId in currentList) {
                currentList
            } else {
                currentList + moduleId
            }
            preferences[PreferencesKey.completedTopicsKey] = gson.toJson(updatedList)
        }
    }

    override fun readModuleIdListForTopic(): Flow<List<Int>> {
        return dataStore.data
            .catch { exception ->
                if (exception is IOException) {
                    emit(emptyPreferences())
                } else {
                    throw exception
                }
            }
            .map { preferences ->
                val jsonString = preferences[PreferencesKey.completedTopicsKey] ?: "[]"
                gson.fromJson<List<Int>>(jsonString, object : TypeToken<List<Int>>() {}.type) ?: emptyList()
            }
    }

    override suspend fun saveModuleIdToListForQuestion(moduleId: Int) {
        dataStore.edit { preferences ->
            val currentList = preferences[PreferencesKey.completedQuestionsKey]?.let {
                runCatching { gson.fromJson<List<Int>>(it, object : TypeToken<List<Int>>() {}.type) }
                    .getOrDefault(emptyList())
            } ?: emptyList()

            val updatedList = if (moduleId in currentList) {
                currentList
            } else {
                currentList + moduleId
            }
            preferences[PreferencesKey.completedQuestionsKey] = gson.toJson(updatedList)
        }
    }

    override fun readModuleIdListForQuestion(): Flow<List<Int>> {
        return dataStore.data
            .catch { exception ->
                if (exception is IOException) {
                    emit(emptyPreferences())
                } else {
                    throw exception
                }
            }
            .map { preferences ->
                val jsonString = preferences[PreferencesKey.completedQuestionsKey] ?: "[]"
                gson.fromJson<List<Int>>(jsonString, object : TypeToken<List<Int>>() {}.type) ?: emptyList()
            }
    }
}