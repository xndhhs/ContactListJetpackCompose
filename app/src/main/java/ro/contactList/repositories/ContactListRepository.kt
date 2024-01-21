package ro.contactList.repositories

import ro.contactList.model.ContactListModel
import ro.contactList.model.ContactModel

interface ContactListRepository {
    suspend fun getContactList(
        pageNumber: Int,
        resultsPerPage: Int,
        seed: String
    ): ContactListModel
}