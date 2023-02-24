package com.cv.uosmsex.presentation.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.cv.uosmsex.model.Contacts
import com.cv.uosmsex.repository.GetContactsRepository
import javax.inject.Inject
import kotlinx.coroutines.launch

class MainViewModel @Inject constructor(private val repository: GetContactsRepository) :
    ViewModel() {

    private val _contactsData = MutableLiveData<ArrayList<Contacts>>()

    val contactsLiveData: LiveData<ArrayList<Contacts>>
        get() = _contactsData

    fun getContacts() {
        viewModelScope.launch {
            val result = repository.getContacts()
            _contactsData.postValue(result)
        }
    }
}