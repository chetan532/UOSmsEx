package com.cv.uosmsex.repository

import com.cv.uosmsex.model.Contacts

interface GetContactsRepository {

    fun getContacts(): List<Contacts>
}