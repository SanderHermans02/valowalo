package com.example.valowalo.data.database

import androidx.room.Dao
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface AgentDao {
    @Query("SELECT * from agents WHERE displayName = :displayName")
    fun getItem(displayName: String): Flow<dbAgent>

    @Query("SELECT * from agents ORDER BY displayName ASC")
    fun getAllItems(): Flow<List<dbAgent>>
}