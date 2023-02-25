package com.cv.uosmsex.presentation.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.cv.uosmsex.repository.GetContactsRepository
import com.cv.uosmsex.repository.MessageRepository
import javax.inject.Inject

class MainViewModelFactory @Inject constructor(
    private val repository: GetContactsRepository,
    private val messagesRepository: MessageRepository
) :
    ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return MainViewModel(repository, messagesRepository) as T
    }
}