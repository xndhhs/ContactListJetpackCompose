package ro.contactList.model

import com.google.gson.annotations.SerializedName

data class ContactListModel(
    @SerializedName("results") val results: List<ContactModel>
)