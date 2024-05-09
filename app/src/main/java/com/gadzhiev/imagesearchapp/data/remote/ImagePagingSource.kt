package com.gadzhiev.imagesearchapp.data.remote

import android.net.http.HttpException
import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.gadzhiev.imagesearchapp.data.toImage
import com.gadzhiev.imagesearchapp.domain.model.Image
import java.io.IOException

class ImagePagingSource(
    val backend: ImageApi,
    val query: String
) : PagingSource<Int, Image>() {
    override fun getRefreshKey(state: PagingState<Int, Image>): Int? {
        return state.anchorPosition
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Image> {
        val startKey = params.key ?: 1
        return try {
            val image = backend.searchImages(
                query = query,
                page = startKey,
                number = params.loadSize
            )

            LoadResult.Page(
                data = image.images.map { it.toImage() },
                prevKey = if (startKey == 1) null else startKey - 1,
                nextKey = image.searchParameters.page + 1
            )


        } catch (e: IOException) {
            return LoadResult.Error(e)
        } catch (e: HttpException) {
            return LoadResult.Error(e)
        } catch (e: Exception) {
            return LoadResult.Error(e)
        }
    }
}