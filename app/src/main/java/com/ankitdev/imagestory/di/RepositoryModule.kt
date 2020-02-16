package com.ankitdev.imagestory.di

import com.ankitdev.imagestory.data.ImageRepositoryImpl
import com.ankitdev.imagestory.data.ImageService
import com.ankitdev.imagestory.domain.ImagesRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 *<h1>RepositoryModule class</h1>

 *<p>Dagger module</p>

 * @author : Ankit
 * @since : 15 Feb 2020
 * @version : 1.0
 */
@Module
class RepositoryModule {

    @Singleton
    @Provides
    fun provideImageRepository(imageService: ImageService): ImagesRepository {
        return ImageRepositoryImpl(imageService)
    }
}