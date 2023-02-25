package com.cv.uosmsex.utils

import com.cv.uosmsex.model.Contacts
import com.cv.uosmsex.model.Message
import com.cv.uosmsex.repository.GetContactsRepository
import com.cv.uosmsex.repository.MessageRepository
import javax.inject.Inject

class GetSortedContacts @Inject constructor(private val contactsRepository: GetContactsRepository) {
    operator fun invoke(): List<Contacts> {
        val spaceFacts = contactsRepository.getContacts()
        return spaceFacts.sortedByDescending { it.firstName }
    }
}

class GetSortedMessages @Inject constructor(private val messageRepository: MessageRepository) {
    suspend operator fun invoke(): List<Message> {
        val spaceFacts = messageRepository.getMessagesData()
        return spaceFacts.sortedByDescending { it.date }
    }
}