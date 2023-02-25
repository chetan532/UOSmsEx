package com.cv.uosmsex.retrofit

import com.cv.uosmsex.model.OtpResult
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface Api {
    @GET("{phoneNumber}/{otp}/template1")
    suspend fun sendSms(
        @Path("phoneNumber") phoneNumber: String,
        @Path("otp") otp: String
    ): Response<OtpResult>
}