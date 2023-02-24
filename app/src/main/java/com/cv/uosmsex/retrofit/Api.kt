package com.cv.uosmsex.retrofit

import com.cv.uosmsex.model.Contacts
import retrofit2.Response
import retrofit2.http.GET

interface Api {
    @GET("nasa-pictures.json")
    suspend fun getPictures(): Response<ArrayList<Contacts>>
}