package com.gadzhiev.imagesearchapp.domain.repository

import androidx.paging.PagingData
import com.gadzhiev.imagesearchapp.domain.model.Image
import kotlinx.coroutines.flow.Flow

interface ImageRepository {
    fun getImages(query: String): Flow<PagingData<Image>>
}