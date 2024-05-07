package com.gadzhiev.imagesearchapp.data.remote.model

data class ImageResponse(
    val domain: String,
    val googleUrl: String,
    val imageHeight: Int,
    val imageUrl: String,
    val imageWidth: Int,
    val link: String,
    val position: Int,
    val source: String,
    val thumbnailHeight: Int,
    val thumbnailUrl: String,
    val thumbnailWidth: Int,
    val title: String
)