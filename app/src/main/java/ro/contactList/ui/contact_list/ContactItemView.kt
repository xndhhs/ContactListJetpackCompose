package ro.contactList.ui.contact_list

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.Center
import androidx.compose.ui.Alignment.Companion.End
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import ro.contactList.R
import ro.contactList.common.Constants.PAPER_CLIP
import ro.contactList.common.Constants.STAR
import ro.contactList.ui.contact_list.ContactListContract.ContactItemUI
import ro.contactList.ui.theme.ContactListTheme
import ro.contactList.ui.theme.custom_font

@Composable
fun ContactItemView(contactItemUI: ContactItemUI) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 16.dp)
    ) {
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp)
        ) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                ProfilePicture(contactItemUI, 60.dp)
                Spacer(modifier = Modifier.width(8.dp))
                UserInfoSection(contactItemUI)
            }
            TimeInfoSection(contactItemUI)
        }
        Text(
            text = STAR,
            fontFamily = custom_font,
            color = MaterialTheme.colorScheme.onSurfaceVariant,
            style = MaterialTheme.typography.headlineMedium,
            modifier = Modifier
                .align(End)
                .padding(end = 16.dp, bottom = 8.dp)
        )
        Divider(
            color = MaterialTheme.colorScheme.surfaceVariant,
            thickness = 0.75.dp
        )
    }
}

@Composable
private fun TimeInfoSection(contactItemUI: ContactItemUI) {
    Column(
        horizontalAlignment = End,
        verticalArrangement = Arrangement.Top
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            if (contactItemUI.hasAttachments) {
                Text(
                    text = PAPER_CLIP,
                    fontFamily = custom_font,
                    style = MaterialTheme.typography.titleLarge
                )
            }
            Spacer(modifier = Modifier.width(4.dp))
            Text(
                text = contactItemUI.timeReceived,
                style = MaterialTheme.typography.bodySmall,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
        }
        Spacer(modifier = Modifier.height(16.dp))
    }
}

@Composable
private fun UserInfoSection(contactItemUI: ContactItemUI) {
    Column {
        Text(
            text = contactItemUI.name,
            style = MaterialTheme.typography.bodyLarge,
            color = MaterialTheme.colorScheme.onSurface
        )
        Text(
            text = String.format(
                stringResource(R.string.age_and_origin),
                contactItemUI.age.toString(),
                contactItemUI.countryOfOrigin
            ),
            style = MaterialTheme.typography.bodySmall,
            color = MaterialTheme.colorScheme.onSurfaceVariant
        )
    }
}

@Composable
private fun ProfilePicture(contactItemUI: ContactItemUI, imageSize: Dp) {
    Card(
        shape = CircleShape,
        border = BorderStroke(
            width = 2.dp,
            color = MaterialTheme.colorScheme.error
        ),
    ) {
        if (contactItemUI.imageURL.isNotEmpty()) {
            AsyncImage(
                model = contactItemUI.imageURL,
                contentDescription = "Content description",
                modifier = Modifier.size(imageSize),
                contentScale = ContentScale.Crop,
            )
        } else {
            Box(
                contentAlignment = Center,
                modifier = Modifier.size(imageSize)
            ) {
                Text(
                    text = contactItemUI.name.substring(0, 1),
                    style = MaterialTheme.typography.displaySmall,
                    color = MaterialTheme.colorScheme.error
                    )
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun ContactItemUIPreview() {
    ContactListTheme {
        Surface(
            color = MaterialTheme.colorScheme.background,
            modifier = Modifier.fillMaxWidth()
        ) {
            ContactItemUI(
                name = "John Doe",
                age = 31,
                countryOfOrigin = "RO",
                timeReceived = "11:56",
                hasAttachments = false,
                isFavourite = false,
                imageURL = "test"
            )
        }
    }
}
