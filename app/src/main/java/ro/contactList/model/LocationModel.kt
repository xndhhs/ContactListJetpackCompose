package ro.contactList.model

data class LocationModel(
    val street: StreetModel,
    val city: String,
    val state: String,
    val country: String,
    val postCode: Int,
    val coordinates: CoordinatesModel,
    val timezone: TimezoneModel,
)