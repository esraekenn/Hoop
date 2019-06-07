package io.androidedu.hoop.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import io.androidedu.hoop.model.CallEntity


@Dao
interface CallDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addNewCall(callEntity: CallEntity)

    @Delete
    fun deleteItem(callEntity: CallEntity)

    @Update
    fun updateItem(callEntity: CallEntity)

    @Query("SELECT * FROM CallTable")
    fun getAllCallList(): LiveData<List<CallEntity>>

    // @Query("SELECT * FROM ChatTable WHERE  _id LİKE:id")
    //fun findChatItem(id:Long):ChatEntity


}