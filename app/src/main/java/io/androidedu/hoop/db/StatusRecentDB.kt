package io.androidedu.hoop.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import io.androidedu.hoop.dao.StatusMutedDao
import io.androidedu.hoop.dao.StatusRecentDao
import io.androidedu.hoop.model.StatusMutedEntity
import io.androidedu.hoop.model.StatusRecentEntity

@Database(entities = [StatusRecentEntity::class], version = 1)
abstract class StatusRecentDB: RoomDatabase() {

    abstract fun getStatusRecentDao(): StatusRecentDao

    companion object {
        private var INSTANCE: StatusRecentDB? = null
        fun getInstance(context: Context): StatusRecentDB? {
            if (INSTANCE == null) {
                synchronized(StatusRecentDB::class) {
                    INSTANCE = Room.databaseBuilder(
                        context.applicationContext,
                        StatusRecentDB::class.java, "status_recent_db"
                    )
                        .fallbackToDestructiveMigration()
                        .build()
                }
            }
            return INSTANCE
        }
    }
}
