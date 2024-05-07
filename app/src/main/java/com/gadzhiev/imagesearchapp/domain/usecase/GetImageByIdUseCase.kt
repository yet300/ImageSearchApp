package com.gadzhiev.imagesearchapp.domain.usecase

import com.gadzhiev.imagesearchapp.domain.repository.ImageRepository
import javax.inject.Inject

class GetImageByIdUseCase @Inject constructor(private val imageRepository: ImageRepository) {
    suspend operator fun invoke(id: String) {
        imageRepository.getImageById(id)
    }

}