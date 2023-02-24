package com.cv.uosmsex.di

import com.cv.uosmsex.repository.GetContactsRepository
import com.cv.uosmsex.utils.GetSortedContacts
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
class MainModule {

    @Provides
    fun provideGetContacts(getContactsRepository: GetContactsRepository) =
        GetSortedContacts(getContactsRepository)
}