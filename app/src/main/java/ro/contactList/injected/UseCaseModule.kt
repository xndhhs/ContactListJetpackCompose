package ro.contactList.injected

import org.koin.dsl.module
import ro.contactList.interactors.ContactListUseCase
import ro.contactList.interactors.ContactListUseCaseImpl

val useCaseModule = module {
    factory<ContactListUseCase> {
        ContactListUseCaseImpl(
            contactListRepository =get()
        )
    }
}