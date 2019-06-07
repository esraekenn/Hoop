package io.androidedu.hoop.model

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "CallTable")
data class CallEntity(

        @PrimaryKey(autoGenerate = true)
        @NonNull
        val _id:Long=0,
        @ColumnInfo(name = "profilePhoto")
        val profilePhoto: Int,
        @ColumnInfo(name = "userName")
        val userName: String,
        @ColumnInfo(name = "date")
        val date: String,
        @ColumnInfo(name="hour")
        val hour: String,
        @ColumnInfo(name = "callImage")
        val callImage:Int,
        @ColumnInfo(name="callSymbol")
        val callSymbol:Int
)
