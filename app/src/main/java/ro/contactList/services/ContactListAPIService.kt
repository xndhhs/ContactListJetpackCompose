package ro.contactList.services

import retrofit2.http.GET
import retrofit2.http.Query
import ro.contactList.model.ContactListModel
import ro.contactList.model.ContactModel

interface ContactListAPIService {

    @GET("/api/")
    suspend fun getContactList(
        @Query("page") pageNumber: Int,
        @Query("results") resultsPerPage: Int,
        @Query("seed") seed: String
    ): ContactListModel
}