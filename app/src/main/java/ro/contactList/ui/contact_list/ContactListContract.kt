package ro.contactList.ui.contact_list

import ro.contactList.common.Constants

class ContactListContract {
    data class State(
        var contactList: List<ContactItemUI>,
        val currentPage: Int,
        val resultsPerPage: Int = Constants.ITEMS_PER_PAGE,
        val seed: String = Constants.SEED
    )

    data class ContactItemUI(
        val imageURL: String,
        val name: String,
        val age: Int,
        val countryOfOrigin: String,
        val timeReceived: String,
        val hasAttachments: Boolean,
        val isFavourite: Boolean
    )
}