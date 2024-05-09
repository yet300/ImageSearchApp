package com.gadzhiev.imagesearchapp.data.remote.repository


import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.gadzhiev.imagesearchapp.data.remote.ImageApi
import com.gadzhiev.imagesearchapp.data.remote.ImagePagingSource
import com.gadzhiev.imagesearchapp.domain.model.Image
import com.gadzhiev.imagesearchapp.domain.repository.ImageRepository
import kotlinx.coroutines.flow.Flow


class ImageRepositoryImpl(
    private val api: ImageApi,
) : ImageRepository {
    override fun getImages(query: String): Flow<PagingData<Image>> {
        return Pager(
            config = PagingConfig(pageSize = 100, enablePlaceholders = false),
            pagingSourceFactory = {
                ImagePagingSource(backend = api, query = query)
            },
        ).flow
    }
}