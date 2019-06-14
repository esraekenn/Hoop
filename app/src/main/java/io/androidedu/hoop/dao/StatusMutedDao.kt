package io.androidedu.hoop.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import io.androidedu.hoop.model.StatusMutedEntity

@Dao
interface StatusMutedDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addNewStatusMuted(statusMutedEntity: StatusMutedEntity)

    @Delete
    fun deleteItem(statusMutedEntity: StatusMutedEntity)

    @Update
    fun updateItem(statusMutedEntity: StatusMutedEntity)

    @Query("SELECT * FROM StatusMuted")
    fun getAllStatusMutedList(): LiveData<List<StatusMutedEntity>>

    // @Query("SELECT * FROM ChatTable WHERE  _id LİKE:id")
    //fun findChatItem(id:Long):ChatEntity


}