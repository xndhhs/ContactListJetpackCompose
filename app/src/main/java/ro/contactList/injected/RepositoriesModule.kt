package ro.contactList.injected

import org.koin.dsl.module
import ro.contactList.repositories.ContactListRepository
import ro.contactList.repositories.ContactListRepositoryImpl

val repositoriesModule = module {
    factory<ContactListRepository> {
        ContactListRepositoryImpl(
            contactListService = get()
        )
    }
}