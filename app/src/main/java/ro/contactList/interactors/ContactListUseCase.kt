package ro.contactList.interactors

import ro.contactList.model.ContactModel

interface ContactListUseCase {
    suspend fun getContactList(): List<ContactModel>
}