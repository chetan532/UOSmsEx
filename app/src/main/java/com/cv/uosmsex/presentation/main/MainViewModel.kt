package com.cv.uosmsex.presentation.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.cv.uosmsex.model.Contacts
import com.cv.uosmsex.model.Message
import com.cv.uosmsex.repository.GetContactsRepository
import com.cv.uosmsex.repository.MessageRepository
import com.cv.uosmsex.utils.GetSortedMessages
import javax.inject.Inject
import kotlinx.coroutines.launch

class MainViewModel @Inject constructor(
    private val repository: GetContactsRepository,
    private val messagesRepository: MessageRepository
) :
    ViewModel() {

    private val _messages = MutableLiveData<List<Message>>()
    val messages: LiveData<List<Message>>
        get() = _messages

    private val _contactsData = MutableLiveData<List<Contacts>>()

    val contactsLiveData: LiveData<List<Contacts>>
        get() = _contactsData

    fun getContacts() {
        viewModelScope.launch {
            val result = repository.getContacts()
            _contactsData.postValue(result)
        }
    }

    fun getMessages() {
        viewModelScope.launch {
            val result = GetSortedMessages(messagesRepository)
            _messages.postValue(result.invoke())
        }
    }
}