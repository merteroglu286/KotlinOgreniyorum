package com.merteroglu286.kotlinogreniyorum.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.merteroglu286.kotlinogreniyorum.domain.model.Module

@Dao
interface ModuleDao {
    @Query("SELECT * FROM module_table ORDER BY id ASC")
    suspend fun getAllModules(): List<Module>

    @Insert()
    suspend fun addModules(modules: List<Module>)

    @Query("DELETE FROM module_table")
    suspend fun deleteAllModules()
}