package ro.contactList

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import ro.contactList.ui.contact_list.ContactListContract
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
                    ContactListApp()
                }
            }
        }
    }
}

@Composable
fun ContactListApp() {
    val navigationController = rememberNavController()
    NavHost(navController = navigationController, startDestination = "contact_list") {
        composable("contact_list") {
            val viewModel: ContactListViewModel = viewModel()
            ContactListScreen(viewModel.state)
        }
    }
}
