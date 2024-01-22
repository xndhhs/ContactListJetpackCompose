package ro.contactList.model

import com.google.gson.annotations.SerializedName

data class InfoModel(
    @SerializedName("seed") val seed: String,
    @SerializedName("results") val resultsPerPage: Int,
    @SerializedName("page") val pageNumber: Int,
    @SerializedName("version") val version: String,
)
