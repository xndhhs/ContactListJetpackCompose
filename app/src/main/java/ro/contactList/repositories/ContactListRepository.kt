package ro.contactList.repositories

import ro.contactList.model.ContactListModel

interface ContactListRepository {
    suspend fun getContactList(
        pageNumber: Int,
        resultsPerPage: Int,
        seed: String
    ): ContactListModel
}