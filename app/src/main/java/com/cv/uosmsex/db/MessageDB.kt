package com.cv.uosmsex.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.cv.uosmsex.model.Message

@Database(entities = [Message::class], version = 1)
abstract class MessageDB : RoomDatabase() {

    abstract fun getMessageDao(): MessagesDao
}