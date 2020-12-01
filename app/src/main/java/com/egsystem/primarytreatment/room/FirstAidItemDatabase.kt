package com.egsystem.roomkot

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.egsystem.primarytreatment.room.FirstAidItemDao
import com.egsystem.primarytreatment.room.FirstAidItemEntity


@Database(entities = [FirstAidItemEntity::class], version = 1)
abstract class FirstAidItemDatabase : RoomDatabase() {

    abstract fun getDao(): FirstAidItemDao

    companion object {

        private var INSTANCE: FirstAidItemDatabase? = null

        fun getDatabase(context: Context): FirstAidItemDatabase {
            var tempInstance: FirstAidItemDatabase? = INSTANCE

            if (tempInstance != null) {
                return tempInstance
            }


            synchronized(this) {
                val instance: FirstAidItemDatabase = Room.databaseBuilder(
                    context,
                    FirstAidItemDatabase::class.java,
                    "note_database"
                ).build()

                return instance
            }

        }

    }

}