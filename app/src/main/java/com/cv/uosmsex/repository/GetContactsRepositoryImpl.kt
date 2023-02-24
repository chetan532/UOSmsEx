package com.cv.uosmsex.repository

import android.app.Application
import com.cv.uosmsex.model.Contacts
import com.cv.uosmsex.utils.parseListFromAssets
import javax.inject.Inject

class GetContactsRepositoryImpl @Inject constructor(private val application: Application) :
    GetContactsRepository {

    override fun getContacts(): ArrayList<Contacts> {
        return parseListFromAssets(
            context = application,
            filename = JSON_FILE_NAME
        )
    }

    companion object {
        const val JSON_FILE_NAME = "contacts.json"
    }
}