package com.cv.uosmsex.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ContactsDto(
    @SerialName("firstName") val firstName: String?,
    @SerialName("lastName") val lastName: String?,
    @SerialName("phone") val phone: String?,
    @SerialName("email") val email: String?,
    @SerialName("image") val image: String?
)