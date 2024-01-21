package ro.contactList.services

import ro.contactList.model.ContactListModel
import ro.contactList.model.ContactModel

interface ContactListService {
    suspend fun getContactList(
        pageNumber: Int,
        resultsPerPage: Int,
        seed: String
    ): ContactListModel
}