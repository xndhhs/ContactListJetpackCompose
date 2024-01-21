package ro.contactList.services

class ContactListServiceImpl(
    private val contactListAPIService: ContactListAPIService
) : ContactListService {
    override suspend fun getContactList(
        pageNumber: Int, resultsPerPage: Int, seed: String
    ) = contactListAPIService.getContactList(
        pageNumber = pageNumber,
        resultsPerPage = resultsPerPage,
        seed = seed
    )
}