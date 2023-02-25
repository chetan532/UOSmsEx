package com.cv.uosmsex.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Message(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val text: String,
    val firstName: String,
    val lastName: String,
    val date: String,
    val otp: String,
    val image: String,
    val email: String,
    val phone: String
)