package io.androidedu.hoop.model

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "ChatTable")
data class ChatEntity(
    @PrimaryKey(autoGenerate=true)
    @NonNull
    val _id:Long = 0,
    @ColumnInfo(name="profilePhoto")
    val profilePhoto: Int,
    @ColumnInfo(name="userName")
    val userName: String,
    @ColumnInfo(name="userMessage")
    val userMessage: String,
    @ColumnInfo(name = "date")
    val date: String
)