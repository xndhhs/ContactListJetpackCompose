package ro.contactList.model

import com.google.gson.annotations.SerializedName

data class ContactModel(
    @SerializedName("gender") val gender: String,
    @SerializedName("name") val name: NameModel,
    @SerializedName("location") val location: LocationModel,
    @SerializedName("email") val email: String,
    @SerializedName("login") val loginData: LoginDataModel,
    @SerializedName("dob") val birthDateData: BirthDateModel,
    @SerializedName("registered") val registerDateData: RegisterDateModel,
    @SerializedName("phone") val phoneNumber: String,
    @SerializedName("cell") val cellNumber: String,
    @SerializedName("id") val userInfoData: UserIdModel,
    @SerializedName("picture") val pictureData: PictureModel,
    @SerializedName("nat") val nationality: String
)