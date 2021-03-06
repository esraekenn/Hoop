package io.androidedu.hoop.model

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "StatusViewed")
data class StatusViewedModel(
    @PrimaryKey(autoGenerate = true)
    @NonNull
    val _id:Long=0,
    @ColumnInfo(name = "profilePhoto")
    val profilePhoto: Int,
    @ColumnInfo(name = "userName")
    val userName: String,
    @ColumnInfo(name="date")
    val date: String
)