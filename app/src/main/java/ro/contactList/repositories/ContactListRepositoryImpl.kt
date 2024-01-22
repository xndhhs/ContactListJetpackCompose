package ro.contactList.repositories

import ro.contactList.services.ContactListService

class ContactListRepositoryImpl(
    private val contactListService: ContactListService
) : ContactListRepository {
    override suspend fun getContactList(
        pageNumber: Int,
        resultsPerPage: Int,
        seed: String
    ) = contactListService.getContactList(
        pageNumber = pageNumber,
        resultsPerPage = resultsPerPage,
        seed = seed
    )
}