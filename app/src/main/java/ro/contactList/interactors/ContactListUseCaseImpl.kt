package ro.contactList.interactors

import ro.contactList.model.ContactModel
import ro.contactList.repositories.ContactListRepository

class ContactListUseCaseImpl(
    private val contactListRepository: ContactListRepository
) : ContactListUseCase {

    override suspend fun getContactList(
        pageNumber: Int,
        resultsPerPage: Int,
        seed: String
    ) = contactListRepository.getContactList(
        pageNumber = pageNumber,
        resultsPerPage = resultsPerPage,
        seed = seed
    )

}
