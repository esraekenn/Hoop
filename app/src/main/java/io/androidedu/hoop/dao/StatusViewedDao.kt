package io.androidedu.hoop.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import io.androidedu.hoop.model.StatusMutedEntity
import io.androidedu.hoop.model.StatusRecentEntity
import io.androidedu.hoop.model.StatusViewedEntity

@Dao
interface StatusViewedDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addNewStatusViewed(statusViewedEntity: StatusViewedEntity)

    @Delete
    fun deleteItem(statusViewedEntity: StatusViewedEntity)

    @Update
    fun updateItem(statusViewedEntity: StatusViewedEntity)

    @Query("SELECT * FROM StatusViewed")
    fun getAllStatusViewedList(): LiveData<List<StatusViewedEntity>>

    // @Query("SELECT * FROM ChatTable WHERE  _id LİKE:id")
    //fun findChatItem(id:Long):ChatEntity


}