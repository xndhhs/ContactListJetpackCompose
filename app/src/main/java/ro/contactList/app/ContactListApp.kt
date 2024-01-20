package ro.contactList.app

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import ro.contactList.injected.appModules

class ContactListApp: Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@ContactListApp)
            modules(appModules)
        }
    }
}