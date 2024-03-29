package com.example.repasroom.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.repasroom.model.Mobles

@Database(
    entities = [Mobles::class],
    version = 1,
    exportSchema = false
)
abstract class MoblesDatabase : RoomDatabase() {
    abstract fun daoMobles(): DaoMobles

    companion object {
        @Volatile
        private var INSTANCE: MoblesDatabase?=null

        fun getDatabase(context: Context): MoblesDatabase {
            if (INSTANCE == null){
                synchronized(this){
                    INSTANCE = buildDatabase(context)
                }
            }
            return INSTANCE!!
        }

        private fun buildDatabase(context: Context): MoblesDatabase {
            return Room.databaseBuilder(
                context.applicationContext,
                MoblesDatabase::class.java,
                "moble_database2"
            ).build()
        }
    }
}