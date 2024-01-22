package ro.contactList.app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import org.koin.androidx.compose.getViewModel
import ro.contactList.ui.contact_list.ContactListScreen
import ro.contactList.ui.contact_list.ContactListViewModel
import ro.contactList.ui.theme.ContactListTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ContactListTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    ContactApp()
                }
            }
        }
    }
}

@Composable
fun ContactApp() {
    val navigationController = rememberNavController()
    NavHost(navController = navigationController, startDestination = "contact_list") {
        composable("contact_list") {
            val viewModel: ContactListViewModel = getViewModel()
            ContactListScreen(viewState = viewModel.state)
        }
    }
}
