package io.androidedu.hoop.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import io.androidedu.hoop.model.ChatEntity

@Dao
interface ChatDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addNewChat(chatEntity: ChatEntity)

    @Delete
    fun deleteItem(chatEntity: ChatEntity)

    @Update
    fun updateItem(chatEntity: ChatEntity)

   @Query("SELECT * FROM ChatTable")
   fun getAllChatList():LiveData<List<ChatEntity>>

   // @Query("SELECT * FROM ChatTable WHERE  _id LİKE:id")
   //fun findChatItem(id:Long):ChatEntity


}