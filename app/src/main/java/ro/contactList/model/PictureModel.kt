package ro.contactList.model

import com.google.gson.annotations.SerializedName

data class PictureModel(
    @SerializedName("large") val large: String,
    @SerializedName("medium") val medium: String,
    @SerializedName("thumbnail") val thumbnail: String
)