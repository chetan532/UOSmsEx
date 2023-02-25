package com.cv.uosmsex.repository

import com.cv.uosmsex.db.MessageDB
import com.cv.uosmsex.model.Message
import javax.inject.Inject

class MessageRepository @Inject constructor(private val messageDB: MessageDB) {

    suspend fun addToMessageDb(message: Message) {
        messageDB.getMessageDao().insertMessage(message)
    }

    suspend fun getMessagesData(): List<Message> {

        return messageDB.getMessageDao().getMessages()
    }
}