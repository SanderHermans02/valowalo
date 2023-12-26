package com.example.valowalo.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

/**
 * Database class with a singleton Instance object.
 */
@Database(entities = [dbAgent::class], version = 2, exportSchema = false)
abstract class AgentDb : RoomDatabase() {

    abstract fun agentDao(): AgentDao

    companion object {
        @Volatile
        private var Instance: AgentDb? = null

        fun getDatabase(context: Context): AgentDb {
            // if the Instance is not null, return it, otherwise create a new database instance.
            return Instance ?: synchronized(this) {
                Room.databaseBuilder(context, AgentDb::class.java, "agent_database")
                    .fallbackToDestructiveMigration()
                    .build()
                    .also { Instance = it }
            }
        }
    }
}
