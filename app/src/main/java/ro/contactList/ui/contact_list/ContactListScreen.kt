package ro.contactList.ui.contact_list

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.FloatingActionButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment.Companion.End
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ro.contactList.common.Constants.EDIT
import ro.contactList.common.Constants.MENU
import ro.contactList.common.Constants.SEARCH
import ro.contactList.ui.contact_list.ContactListContract.State
import ro.contactList.ui.theme.ContactListTheme
import ro.contactList.ui.theme.custom_font

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ContactListScreen(viewState: androidx.compose.runtime.State<State>) {
    val state = viewState.value

    Column() {
        CenterAlignedTopAppBar(
            title = {
                Text(
                    text = "Users",
                    style = MaterialTheme.typography.titleLarge,
                    color = Color.White,
                )
            },
            navigationIcon = {
                Text(
                    text = MENU,
                    fontFamily = custom_font,
                    fontSize = 36.sp,
                    color = Color.White,
                )
            },
            actions = {
                Text(
                    text = SEARCH,
                    color = Color.White,
                    fontFamily = custom_font,
                    fontSize = 36.sp,
                    modifier = Modifier.padding(end = 8.dp)
                )
            },
            colors = TopAppBarDefaults.centerAlignedTopAppBarColors(containerColor = Color.Red)
        )

        LazyColumn(modifier = Modifier.weight(1f)) {
            items(
                count = state.contactList.size,
                key = { state.contactList[it].name },
                contentType = { ContactListContract.ContactItemUI::class.java },
                itemContent = { index ->
                    ContactItemView(
                        state.contactList[index]
                    )
                }
            )
        }
        FloatingActionButton(
            modifier = Modifier
                .align(End)
                .padding(16.dp),
            shape = CircleShape,
            containerColor = Color.Red,
            contentColor = Color.White,
            elevation = FloatingActionButtonDefaults.elevation(defaultElevation = 4.dp),
            onClick = { /*TODO*/ }) {
            Text(
                text = EDIT,
                color = Color.White,
                fontFamily = custom_font,
                fontSize = 48.sp
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ContactListScreenPreview() {
    ContactListTheme {
        Surface(
            color = MaterialTheme.colorScheme.background,
            modifier = Modifier.fillMaxWidth()
        ) {
            val viewState = remember {
                mutableStateOf(
                    State(
                        contactList = listOf(
                            ContactListContract.ContactItemUI(
                                name = "John Doe",
                                age = 31,
                                countryOfOrigin = "RO",
                                timeReceived = "11:56",
                                hasAttachments = false,
                                isFavourite = false,
                                imageURL = "test"
                            ),
                            ContactListContract.ContactItemUI(
                                name = "Jane Doe",
                                age = 22,
                                countryOfOrigin = "DE",
                                timeReceived = "08:56",
                                hasAttachments = true,
                                isFavourite = false,
                                imageURL = "test"
                            )
                        ),
                        initialPage = 0, resultsPerPage = 20, seed = "abc",
                    )
                )
            }
            ContactListScreen(viewState = viewState)
        }
    }
}