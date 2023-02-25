package com.cv.uosmsex.presentation.compose

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.cv.uosmsex.model.Message
import com.cv.uosmsex.model.OtpResult
import com.cv.uosmsex.repository.MessageRepository
import com.cv.uosmsex.repository.SendSmsRepository
import javax.inject.Inject
import kotlinx.coroutines.launch

class ComposeViewModel @Inject constructor(
    private val messagesRepository: MessageRepository,
    private val sendSmsRepository: SendSmsRepository
) :
    ViewModel() {

    private val _sendResponse = MutableLiveData<com.cv.uosmsex.retrofit.Result<OtpResult>>()

    val sendResponse: LiveData<com.cv.uosmsex.retrofit.Result<OtpResult>>
        get() = _sendResponse

    fun addMessage(message: Message) {
        viewModelScope.launch {
            messagesRepository.addToMessageDb(message)
        }
    }

    fun sendOTP(phoneNumber: String, otp: String) {
        viewModelScope.launch {
            val result = sendSmsRepository.sendOTP(phoneNumber, otp)
            _sendResponse.postValue(result)
        }
    }
}