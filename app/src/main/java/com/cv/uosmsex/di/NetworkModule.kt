package com.cv.uosmsex.di

import com.cv.uosmsex.repository.GetContactsRepository
import com.cv.uosmsex.retrofit.Api
import com.cv.uosmsex.utils.Constants
import com.cv.uosmsex.utils.GetSortedContacts
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import java.util.concurrent.TimeUnit
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
class NetworkModule {

    @Provides
    fun providesRetrofit(): Retrofit {

        val gson = GsonBuilder()
            .setLenient()
            .create()

        val client = OkHttpClient.Builder()
        val clientBuilder = client.connectTimeout(30, TimeUnit.SECONDS)
            .readTimeout(30, TimeUnit.SECONDS)
            .build()

        return Retrofit.Builder().baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .client(clientBuilder)
            .build()
    }

    @Provides
    fun providesApi(retrofit: Retrofit): Api {
        return retrofit.create(Api::class.java)
    }

    @Provides
    fun provideGetSortedFactsUseCase(spaceFactRepository: GetContactsRepository) =
        GetSortedContacts(spaceFactRepository)
}