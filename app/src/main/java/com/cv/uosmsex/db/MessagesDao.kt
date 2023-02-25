package com.cv.uosmsex.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.cv.uosmsex.model.Message

@Dao
interface MessagesDao {

    @Insert
    suspend fun insertMessage(message: Message)

    @Update
    suspend fun updateMessage(message: Message)

    @Query("DELETE FROM Message")
    suspend fun delete()

    @Query("SELECT * FROM Message")
    suspend fun getMessages(): List<Message>

    @Query("SELECT * FROM Message where id = :messageId ")
    suspend fun getQuoteById(messageId: Int): Message
}