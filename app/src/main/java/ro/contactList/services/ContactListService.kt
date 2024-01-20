package ro.contactList.services

import ro.contactList.model.ContactModel

interface ContactListService {
    suspend fun getContactList(): List<ContactModel>
}