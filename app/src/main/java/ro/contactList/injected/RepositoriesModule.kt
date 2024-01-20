package ro.contactList.injected

import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module
import ro.contactList.services.ContactListService
import ro.contactList.services.ContactListServiceImpl

val repositoriesModule = module {
    factory<ContactListService> {
        ContactListServiceImpl(
            contactListAPIService = get(),
            context = androidContext()
        )
    }
}