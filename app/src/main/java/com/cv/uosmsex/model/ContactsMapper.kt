package com.cv.uosmsex.model

fun ContactsDto.toContacts(): Contacts {
    return Contacts(
        firstName = this.firstName ?: "",
        lastName = this.lastName ?: "",
        phone = this.phone ?: "",
        email = this.email ?: "",
        image = this.image ?: ""
    )
}