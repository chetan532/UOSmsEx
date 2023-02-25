package com.cv.uosmsex.repository

import com.cv.uosmsex.model.OtpResult
import com.cv.uosmsex.retrofit.Api
import com.cv.uosmsex.retrofit.Result
import javax.inject.Inject

class SendSmsRepository @Inject constructor(private val api: Api) {

    suspend fun sendOTP(phoneNumber: String, otp: String): Result<OtpResult> {
        val result = api.sendSms(phoneNumber, otp)

        return if (result.isSuccessful) {
            val responseBody = result.body()

            if (responseBody != null) {
                Result.Success(result.body())
            } else {
                Result.Error("API Error")
            }
        } else {
            Result.Error("API Error")
        }
    }
}