package ro.contactList.ui.contact_list

class ContactListContract {
    data class State(
        val contactList: List<ContactItemUI>
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