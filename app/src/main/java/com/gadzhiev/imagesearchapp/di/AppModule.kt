package com.gadzhiev.imagesearchapp.di

import com.gadzhiev.imagesearchapp.data.remote.repository.ImageRepositoryImpl
import com.gadzhiev.imagesearchapp.data.remote.ImageApi
import com.gadzhiev.imagesearchapp.domain.repository.ImageRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideApi(): ImageApi {
        return ImageApi(
            baseUrl = "https://google.serper.dev",
            apiKey = "aa41aa2af541faf17493fec66bb1a789ae95cca5"
        )
    }


    @Provides
    fun provideRepository(
    ): ImageRepository {
        return ImageRepositoryImpl(
            api = provideApi(),
        )
    }
}