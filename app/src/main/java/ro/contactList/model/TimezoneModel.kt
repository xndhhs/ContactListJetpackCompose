package ro.contactList.model

import com.google.gson.annotations.SerializedName

data class TimezoneModel(
    @SerializedName("offset") val offset: String,
    @SerializedName("description") val description: String
)
