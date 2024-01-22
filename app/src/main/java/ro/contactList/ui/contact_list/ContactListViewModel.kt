package ro.contactList.ui.contact_list

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import ro.contactList.interactors.ContactListUseCase
import ro.contactList.ui.contact_list.ContactListContract.State

class ContactListViewModel(
    private val contactListUseCase: ContactListUseCase
) : ViewModel() {

    val state: MutableState<State> = mutableStateOf(State(emptyList(), 0))

    init {
        viewModelScope.launch(Dispatchers.IO) {
            val contactList = contactListUseCase.getContactList(
                pageNumber = 0,
                resultsPerPage = 20,
                seed = "abc"
            )
            val contactListUI = ContactItemUiTranslator.mapContentModelToUi(contactList.results)
            state.value.contactList = contactListUI
        }
    }
}

