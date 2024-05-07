package com.gadzhiev.imagesearchapp.domain.usecase

import androidx.paging.PagingData
import com.gadzhiev.imagesearchapp.domain.model.Image
import com.gadzhiev.imagesearchapp.domain.repository.ImageRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetImagesUseCase @Inject constructor(private val imageRepository: ImageRepository) {
    operator fun invoke(query: String): Flow<PagingData<Image>> {
        return imageRepository.getImages(query)
    }
}