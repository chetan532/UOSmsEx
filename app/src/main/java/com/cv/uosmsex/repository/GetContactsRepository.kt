package com.cv.uosmsex.repository

import com.cv.uosmsex.model.Contacts

interface GetContactsRepository {

    fun getContacts(): ArrayList<Contacts>

}