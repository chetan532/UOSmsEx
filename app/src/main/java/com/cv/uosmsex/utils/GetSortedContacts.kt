package com.cv.uosmsex.utils

import com.cv.uosmsex.model.Contacts
import com.cv.uosmsex.repository.GetContactsRepository

class GetSortedContacts constructor(private val contactsRepository: GetContactsRepository) {
    operator fun invoke(): List<Contacts> {
        val spaceFacts = contactsRepository.getContacts()
        return spaceFacts.sortedByDescending { it.firstName }
    }
}