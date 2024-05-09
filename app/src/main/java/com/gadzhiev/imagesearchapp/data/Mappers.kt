package com.gadzhiev.imagesearchapp.data


import com.gadzhiev.imagesearchapp.data.remote.model.ImageResponse
import com.gadzhiev.imagesearchapp.domain.model.Image


internal fun ImageResponse.toImage(): Image {
    return Image(
        domain = domain,
        googleUrl = googleUrl,
        imageHeight = imageHeight,
        imageUrl = imageUrl,
        imageWidth = imageWidth,
        link = link,
        position = position,
        source = source,
        thumbnailHeight = thumbnailHeight,
        thumbnailUrl = thumbnailUrl,
        thumbnailWidth = thumbnailWidth,
        title = title,
    )
}
