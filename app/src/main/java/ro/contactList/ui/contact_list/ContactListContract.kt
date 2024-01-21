package ro.contactList.ui.contact_list

class ContactListContract {
    data class State(
        var contactList: List<ContactItemUI>,
        val initialPage: Int,
        val resultsPerPage: Int = 20,
        val seed: String = "abc"
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