package ro.contactList.repositories

import kotlinx.coroutines.delay
import ro.contactList.model.ContactListModel
import ro.contactList.services.ContactListService

class ContactListRepositoryImpl(
    private val contactListService: ContactListService
) : ContactListRepository {
    override suspend fun getContactList(
        pageNumber: Int,
        resultsPerPage: Int,
        seed: String
    ): ContactListModel {
        delay(3000L)
        return contactListService.getContactList(
            pageNumber = pageNumber,
            resultsPerPage = resultsPerPage,
            seed = seed
        )
    }
}