package ro.contactList.interactors

import ro.contactList.model.ContactModel
import ro.contactList.repositories.ContactListRepository

class ContactListUseCaseImpl(
    private val contactListRepository: ContactListRepository
) : ContactListUseCase {

    override suspend fun getContactList() = contactListRepository.getContactList()

}
