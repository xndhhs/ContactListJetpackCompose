package ro.contactList.services

import android.content.Context
import ro.contactList.model.ContactModel

class ContactListServiceImpl(
    private val contactListAPIService: ContactListAPIService,
    context: Context
) : ContactListService {
    override suspend fun getContactList() = contactListAPIService.getContactList()
}