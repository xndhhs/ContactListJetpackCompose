package ro.contactList.repositories

import ro.contactList.model.ContactModel

interface ContactListRepository {
    suspend fun getContactList(): List<ContactModel>
}