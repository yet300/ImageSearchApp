package com.gadzhiev.imagesearchapp.presentation.screns.main



import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.paging.LoadState
import androidx.paging.compose.LazyPagingItems
import androidx.paging.compose.collectAsLazyPagingItems
import com.gadzhiev.imagesearchapp.domain.model.Image
import com.gadzhiev.imagesearchapp.presentation.screns.main.component.ListScreen
import com.gadzhiev.imagesearchapp.presentation.screns.main.component.LoadItem
import com.gadzhiev.imagesearchapp.presentation.screns.main.component.SearchBar

@Composable
fun MainScreen(
) {
    MainScreen(viewModel = viewModel())
}

@Composable
internal fun MainScreen(
    viewModel: MainViewModel,
) {
    val search by viewModel.search.collectAsState()
    val images: LazyPagingItems<Image> = viewModel.imagesSearchResults.collectAsLazyPagingItems()

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            SearchBar(query = search, onQueryChanged = viewModel::setSearch, label = "Search")
        },
        content = {
            when (images.loadState.refresh) {
                is LoadState.Error -> {
                    ErrorScreen(reLoad = {
                        images.refresh()
                    })
                }

                is LoadState.Loading -> {
                    LoadItem()
                }

                else -> {
                    ListScreen(
                        images = images, contentPaddingValues = it,
                    )
                }
            }
        }
    )
}
