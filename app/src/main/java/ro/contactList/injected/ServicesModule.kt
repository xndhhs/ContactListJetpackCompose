package ro.contactList.injected

import org.koin.dsl.module
import ro.contactList.services.ContactListService
import ro.contactList.services.ContactListServiceImpl

val servicesModule = module {
    factory<ContactListService> {
        ContactListServiceImpl(
            contactListAPIService = get()
        )
    }
}