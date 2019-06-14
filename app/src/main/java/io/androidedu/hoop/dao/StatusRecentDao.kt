package io.androidedu.hoop.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import io.androidedu.hoop.model.StatusMutedEntity
import io.androidedu.hoop.model.StatusRecentEntity

@Dao
interface StatusRecentDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addNewStatusRecent(statusRecentEntity: StatusRecentEntity)

    @Delete
    fun deleteItem(statusRecentEntity: StatusRecentEntity)

    @Update
    fun updateItem(statusRecentEntity: StatusRecentEntity)

    @Query("SELECT * FROM StatusRecent")
    fun getAllStatusRecentList(): LiveData<List<StatusRecentEntity>>

    // @Query("SELECT * FROM ChatTable WHERE  _id LİKE:id")
    //fun findChatItem(id:Long):ChatEntity


}