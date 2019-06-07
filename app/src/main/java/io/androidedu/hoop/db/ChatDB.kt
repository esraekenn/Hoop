package io.androidedu.hoop.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import io.androidedu.hoop.dao.ChatDao
import io.androidedu.hoop.model.ChatEntity

@Database(entities = [ChatEntity::class], version = 1)
abstract class HoopDB: RoomDatabase() {

    abstract fun getChatDao(): ChatDao

    companion object {
        private var INSTANCE: HoopDB? = null
        fun getInstance(context: Context): HoopDB? {
            if (INSTANCE == null) {
                synchronized(HoopDB::class) {
                    INSTANCE = Room.databaseBuilder(
                        context.applicationContext,
                        HoopDB::class.java, "hoop_db"
                    )
                        .fallbackToDestructiveMigration()
                        .build()
                }
            }
            return INSTANCE
        }
    }
    }

