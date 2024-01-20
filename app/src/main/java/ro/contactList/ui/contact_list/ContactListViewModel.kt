package ro.contactList.ui.contact_list

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import ro.contactList.interactors.ContactListUseCase

class ContactListViewModel(
    private val contactListUseCase: ContactListUseCase
) : ViewModel() {
    init {
        viewModelScope.launch {
            val contactList = contactListUseCase.getContactList()
            val contactListUI = ContactItemUiTranslator.mapContentModelToUi(contactList)
            state.value.copy(contactList = contactListUI)
        }
    }

   val state: MutableState<ContactListContract.State> = mutableStateOf(
        ContactListContract.State(
            emptyList()
        )
    )
}