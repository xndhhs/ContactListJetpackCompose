package ro.contactList.injected

import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import ro.contactList.ui.contact_list.ContactListViewModel

val viewModelModule = module {
    viewModel {
        ContactListViewModel(
            contactListUseCase =get()
        )
    }
}