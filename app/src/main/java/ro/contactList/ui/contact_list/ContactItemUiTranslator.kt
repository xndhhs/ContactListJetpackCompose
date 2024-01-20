package ro.contactList.ui.contact_list

import ro.contactList.model.ContactModel
import kotlin.random.Random

object ContactItemUiTranslator {

    fun mapContentModelToUi(contactModelList: List<ContactModel>) :List<ContactListContract.ContactItemUI> {
        return contactModelList.map {
            ContactListContract.ContactItemUI(
                imageURL = it.pictureData.thumbnail,
                name = it.name.first+" "+it.name.last,
                age = it.birthDateData.age,
                countryOfOrigin = it.nationality,
                timeReceived = "11:11",
                hasAttachments = Random.nextBoolean(),
                isFavourite = false
            )
        }
    }
}