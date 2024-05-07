package com.gadzhiev.imagesearchapp.data.remote.model

data class SearchParameters(
    val engine: String = "",
    val num: Int = 10,
    val page: Int,
    val q: String = "",
    val type: String = ""
)