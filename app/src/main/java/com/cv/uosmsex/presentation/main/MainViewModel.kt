package com.cv.uosmsex.presentation.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.cv.uosmsex.model.Contacts
import com.cv.uosmsex.repository.GetContactsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.launch

@HiltViewModel
class MainViewModel @Inject constructor(private val repository: GetContactsRepository) :
    ViewModel() {

    private val _contactsData = MutableLiveData<List<Contacts>>()

    val contactsLiveData: LiveData<List<Contacts>>
        get() = _contactsData

    fun getContacts() {
        viewModelScope.launch {
            val result = repository.getContacts()
            _contactsData.postValue(result)
        }
    }
}