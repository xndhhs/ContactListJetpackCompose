package ro.contactList.interactors

import androidx.paging.PagingSource
import androidx.paging.PagingState
import ro.contactList.common.Constants
import ro.contactList.common.Constants.SEED
import ro.contactList.repositories.ContactListRepository
import ro.contactList.ui.contact_list.ContactItemUiTranslator
import ro.contactList.ui.contact_list.ContactListContract
import java.lang.Exception

class ContactListUseCase(
    private val contactListRepository: ContactListRepository
) : PagingSource<Int, ContactListContract.ContactItemUI>() {
    override fun getRefreshKey(state: PagingState<Int, ContactListContract.ContactItemUI>): Int? {
        return state.anchorPosition?.let { position ->
            val page = state.closestPageToPosition(position)
            page?.prevKey?.minus(1) ?: page?.nextKey?.plus(1)
        }
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, ContactListContract.ContactItemUI> {
        return try {
            val page = params.key ?: 1
            val response = ContactItemUiTranslator.mapContentModelToUi(contactListRepository.getContactList(page, 20, SEED).results)
            LoadResult.Page(
                data = response,
                prevKey = null,
                nextKey = if (contactListRepository.getContactList(page, 20, SEED).infoMode.pageNumber <= Constants.MAX_PAGE) page + 1 else null
            )
        } catch (e: Exception) {
            LoadResult.Error(e)
        }
    }
}