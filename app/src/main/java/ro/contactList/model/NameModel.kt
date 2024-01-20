package ro.contactList.model

import com.google.gson.annotations.SerializedName

data class NameModel(
    @SerializedName("title") val title: String,
    @SerializedName("first") val first: String,
    @SerializedName("last") val last: String,
)