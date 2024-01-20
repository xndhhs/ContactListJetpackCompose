package ro.contactList.repositories

import ro.contactList.model.ContactModel
import ro.contactList.services.ContactListService

class ContactListRepositoryImpl(
    private val contactListService: ContactListService
) : ContactListRepository {

    override suspend fun getContactList() = contactListService.getContactList()

}