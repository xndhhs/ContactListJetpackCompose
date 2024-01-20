package ro.contactList.services

import retrofit2.http.GET
import ro.contactList.model.ContactModel

interface ContactListAPIService {

    @GET
    suspend fun getContactList(): List<ContactModel>
}