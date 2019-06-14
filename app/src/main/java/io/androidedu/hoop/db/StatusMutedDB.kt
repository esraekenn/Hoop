package io.androidedu.hoop.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import io.androidedu.hoop.dao.StatusMutedDao
import io.androidedu.hoop.model.StatusMutedEntity

@Database(entities = [StatusMutedEntity::class], version = 1)
abstract class StatusMutedDB: RoomDatabase() {

    abstract fun getStatusMutedDao(): StatusMutedDao
    companion object {
        private var INSTANCE: StatusMutedDB? = null
        fun getInstance(context: Context): StatusMutedDB? {
            if (INSTANCE == null) {
                synchronized(StatusMutedDB::class) {
                    INSTANCE = Room.databaseBuilder(
                        context.applicationContext,
                        StatusMutedDB::class.java, "status_muted_db"
                    )
                        .fallbackToDestructiveMigration()
                        .build()
                }
            }
            return INSTANCE
        }
    }
}
