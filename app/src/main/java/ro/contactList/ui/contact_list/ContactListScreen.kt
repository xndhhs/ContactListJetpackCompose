package ro.contactList.ui.contact_list

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.FloatingActionButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.paging.LoadState
import androidx.paging.compose.LazyPagingItems
import androidx.paging.compose.collectAsLazyPagingItems
import org.koin.androidx.compose.getViewModel
import ro.contactList.R
import ro.contactList.common.Constants.EDIT
import ro.contactList.common.Constants.MENU
import ro.contactList.common.Constants.SEARCH
import ro.contactList.ui.theme.ContactListTheme
import ro.contactList.ui.theme.custom_font


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ContactListScreen(viewModel: ContactListViewModel) {
    val state = viewModel.contactPager.collectAsLazyPagingItems()
    Scaffold(
        topBar = {
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
        },
        content = { MainContentSection(state) },
        floatingActionButton = {
            FloatingActionButton(
                modifier = Modifier
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

    )
}

@Composable
private fun MainContentSection(state: LazyPagingItems<ContactListContract.ContactItemUI>) {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 60.dp)
    ) {
        items(
            count = state.itemCount,
            contentType = { ContactListContract.ContactItemUI::class.java },
            itemContent = { index ->
                state[index]?.let { ContactItemView(it) }
            }
        )
        when (state.loadState.append) {
            is LoadState.Error -> {item {  ErrorLoadingItems() } }
            is LoadState.Loading -> {item {  LoadingItems()} }
            is LoadState.NotLoading -> Unit
        }
        when (state.loadState.refresh) {
            is LoadState.Error -> {item {  ErrorLoadingItems() } }
            is LoadState.Loading -> {item {  LoadingItems()} }
            is LoadState.NotLoading -> Unit
        }
    }
}

@Composable
fun ErrorLoadingItems() {
   Row(modifier = Modifier.background(color = Color.Red)) {
       Text(text = stringResource(R.string.error_occurred), style = MaterialTheme.typography.displayMedium)
   }
}

@Composable
fun LoadingItems(){
    Box(modifier = Modifier.fillMaxSize(),
    contentAlignment = Alignment.Center){
        CircularProgressIndicator(
            modifier = Modifier.size(60.dp),
            strokeWidth = 8.dp
        )

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
            val viewModel = getViewModel<ContactListViewModel>()
            ContactListScreen(viewModel = viewModel)
        }
    }
}