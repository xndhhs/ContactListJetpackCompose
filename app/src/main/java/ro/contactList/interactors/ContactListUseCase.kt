package ro.contactList.interactors

import ro.contactList.model.ContactListModel
import ro.contactList.model.ContactModel

interface ContactListUseCase {
    suspend fun getContactList(
        pageNumber: Int,
        resultsPerPage: Int,
        seed: String
    ): ContactListModel
}