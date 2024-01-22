package ro.contactList.services

import ro.contactList.model.ContactListModel

interface ContactListService {
    suspend fun getContactList(
        pageNumber: Int,
        resultsPerPage: Int,
        seed: String
    ): ContactListModel
}