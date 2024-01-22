package ro.contactList.ui.contact_list

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.cachedIn
import ro.contactList.common.Constants.ITEMS_PER_PAGE
import ro.contactList.interactors.ContactListUseCase
import ro.contactList.repositories.ContactListRepository

class ContactListViewModel(
    private val contactListRepository: ContactListRepository
) : ViewModel() {

    val contactPager = Pager(
        PagingConfig(pageSize = ITEMS_PER_PAGE, prefetchDistance = ITEMS_PER_PAGE - 3)
    ) {
        ContactListUseCase(contactListRepository)
    }.flow.cachedIn(viewModelScope)

}

