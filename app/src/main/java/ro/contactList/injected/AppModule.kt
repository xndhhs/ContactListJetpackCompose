package ro.contactList.injected

import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.create
import ro.contactList.services.ContactListAPIService
import ro.contactList.services.RetrofitClientFactory


val apiModule = module {
    single { RetrofitClientFactory.create() }
    single { get<Retrofit>().create(ContactListAPIService::class.java) }
}

val appModules = listOf(apiModule, viewModelModule, useCaseModule, repositoriesModule)
