package com.gadzhiev.imagesearchapp.presentation.screns.main.component

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.unit.dp
import androidx.paging.LoadState
import androidx.paging.compose.LazyPagingItems
import com.gadzhiev.imagesearchapp.domain.model.Image


@Composable
fun ListScreen(
    images: LazyPagingItems<Image>,
    contentPaddingValues: PaddingValues,
) {
    val uriHandler = LocalUriHandler.current

    LazyVerticalStaggeredGrid(
        modifier = Modifier
            .fillMaxSize(),
        columns = StaggeredGridCells.Fixed(2),
        verticalItemSpacing = 4.dp,
        horizontalArrangement = Arrangement.spacedBy(4.dp),
        contentPadding = contentPaddingValues,
    ) {
        items(images.itemCount) {
            images[it]?.let { images ->
                ImageItem(
                    image = images,
                    modifier = Modifier.clickable {
                        uriHandler.openUri(
                            images.googleUrl
                        )
                    }
                )
            }
        }
        item {
            if (images.loadState.append is LoadState.Loading) {
                CircularProgressIndicator()
            }
        }

    }
}

