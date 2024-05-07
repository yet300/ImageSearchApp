package com.gadzhiev.imagesearchapp.data.remote.model

data class ImageDto(
    val images: List<ImageResponse>,
    val searchParameters: SearchParameters
)