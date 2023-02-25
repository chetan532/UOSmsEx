package com.cv.uosmsex.presentation.compose

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.cv.uosmsex.repository.MessageRepository
import com.cv.uosmsex.repository.SendSmsRepository
import javax.inject.Inject

class ComposeViewModelFactory @Inject constructor(
    private val messagesRepository: MessageRepository,
    private val sendSmsRepository: SendSmsRepository
) :
    ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return ComposeViewModel(messagesRepository, sendSmsRepository) as T
    }
}