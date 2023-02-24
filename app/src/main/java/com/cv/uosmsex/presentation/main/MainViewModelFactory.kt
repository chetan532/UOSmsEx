package com.cv.uosmsex.presentation.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.cv.uosmsex.repository.GetContactsRepository
import javax.inject.Inject

class MainViewModelFactory @Inject constructor(private val repository: GetContactsRepository) :
    ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return MainViewModel(repository) as T
    }
}