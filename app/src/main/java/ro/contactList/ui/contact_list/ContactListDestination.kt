package ro.contactList.ui.contact_list

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavController
import org.koin.androidx.compose.getViewModel

@Composable
fun ContactListDestination(
    navController: NavController
) {
    val viewModel = getViewModel<ContactListViewModel>()

}