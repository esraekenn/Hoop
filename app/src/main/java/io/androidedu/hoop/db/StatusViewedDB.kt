package io.androidedu.hoop.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import io.androidedu.hoop.dao.StatusMutedDao
import io.androidedu.hoop.dao.StatusViewedDao
import io.androidedu.hoop.model.StatusMutedEntity
import io.androidedu.hoop.model.StatusRecentEntity
import io.androidedu.hoop.model.StatusViewedEntity

@Database(entities = [StatusViewedEntity::class], version = 1)
abstract class StatusViewedDB: RoomDatabase() {

    abstract fun getStatusViewedDao(): StatusViewedDao

    companion object {
        private var INSTANCE: StatusViewedDB? = null
        fun getInstance(context: Context): StatusViewedDB? {
            if (INSTANCE == null) {
                synchronized(StatusViewedDB::class) {
                    INSTANCE = Room.databaseBuilder(
                        context.applicationContext,
                        StatusViewedDB::class.java, "status_viewed_db"
                    )
                        .fallbackToDestructiveMigration()
                        .build()
                }
            }
            return INSTANCE
        }
    }
}
