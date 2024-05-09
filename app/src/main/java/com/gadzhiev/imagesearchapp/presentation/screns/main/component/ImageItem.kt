package com.gadzhiev.imagesearchapp.presentation.screns.main.component

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.SubcomposeAsyncImage
import coil.request.ImageRequest
import com.gadzhiev.imagesearchapp.domain.model.Image


@Composable
fun ImageItem(
    image: Image,
    modifier: Modifier = Modifier
) {
    OutlinedCard(
        modifier = modifier
            .wrapContentSize(),
    ) {
        SubcomposeAsyncImage(
            model = ImageRequest.Builder(LocalContext.current)
                .data(image.imageUrl)
                .crossfade(true)
                .build(),
            loading = {
                CircularProgressIndicator()
            },
            contentScale = ContentScale.Crop,
            contentDescription = image.title,
            modifier = modifier
                .clip(MaterialTheme.shapes.medium)
                .fillMaxWidth()
                .defaultMinSize(250.dp)
        )
        Column(
            modifier = modifier
                .padding(4.dp)
        ) {
            Text(
                text = image.source,
                style = MaterialTheme.typography.bodySmall,
                maxLines = 1,
            )
            Spacer(modifier = Modifier.padding(2.dp))
            Text(
                text = image.title,
                style = MaterialTheme.typography.titleMedium,
                fontSize = 12.sp,
                maxLines = 2,
            )
        }
    }
}
