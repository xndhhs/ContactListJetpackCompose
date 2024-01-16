package ro.contactList.model

data class ContactModel(
  val gender: String,
  val name: NameModel,
  val location: LocationModel,
  val email: String,
  val loginData: LoginDataModel,
  val birthDateData: BirthDateModel,
  val registerDateData: RegisterDateModel,
  val phoneNumber: String,
  val cellNumber: String,
  val userInfoData: UserIdModel,
  val pictureData: PictureModel,
  val nationality: String
)