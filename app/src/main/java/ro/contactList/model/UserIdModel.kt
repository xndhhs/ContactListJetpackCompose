package ro.contactList.model

import com.google.gson.annotations.SerializedName

data class UserIdModel(
    @SerializedName("name") val name: String,
    @SerializedName("value") val value: String
)
