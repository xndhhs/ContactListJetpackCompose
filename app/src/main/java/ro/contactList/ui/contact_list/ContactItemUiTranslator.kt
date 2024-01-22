package ro.contactList.ui.contact_list

import ro.contactList.common.Constants.DATE_FORMAT_API
import ro.contactList.common.Constants.DATE_FORMAT_UI
import ro.contactList.common.DateFormatUtil
import ro.contactList.model.ContactModel
import kotlin.random.Random

object ContactItemUiTranslator {

    fun mapContentModelToUi(contactModelList: List<ContactModel>): List<ContactListContract.ContactItemUI> {
        return contactModelList.map {
            ContactListContract.ContactItemUI(
                imageURL = it.pictureData.thumbnail,
                name = it.name.first + " " + it.name.last,
                age = it.birthDateData.age,
                countryOfOrigin = it.nationality,
                timeReceived = DateFormatUtil.formatDate(
                    it.registerDateData.date,
                    DATE_FORMAT_API,
                    DATE_FORMAT_UI
                ),
                hasAttachments = Random.nextBoolean(),
                isFavourite = false
            )
        }
    }
}