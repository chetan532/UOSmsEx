package com.cv.uosmsex.di

import android.content.Context
import androidx.room.Room
import com.cv.uosmsex.db.MessageDB
import dagger.Module
import dagger.Provides

@Module
class DatabaseModule {

    @Provides
    fun provideMessageDB(context: Context): MessageDB {

        return Room.databaseBuilder(context, MessageDB::class.java, "messages").build()
    }
}