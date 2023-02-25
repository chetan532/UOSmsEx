package com.cv.uosmsex.repository

import android.content.Context
import com.cv.uosmsex.model.Contacts
import com.cv.uosmsex.model.ContactsDto
import com.cv.uosmsex.model.toContacts
import com.cv.uosmsex.utils.parseListFromAssets
import javax.inject.Inject

class GetContactsRepository @Inject constructor(private val context: Context) {

    fun getContacts(): List<Contacts> {
        val contactsDto = parseListFromAssets<ContactsDto>(
            context = context,
            filename = "contacts.json"
        )
        return contactsDto.map { it.toContacts() }
    }
}