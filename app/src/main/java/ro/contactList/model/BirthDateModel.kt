package ro.contactList.model

import com.google.gson.annotations.SerializedName

data class BirthDateModel(
    @SerializedName("date") val date: String,
    @SerializedName("age") val age: Int
)
