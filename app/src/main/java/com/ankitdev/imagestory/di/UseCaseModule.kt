package com.ankitdev.imagestory.di

import com.ankitdev.imagestory.domain.GetImageUseCase
import com.ankitdev.imagestory.domain.GetImageUseCaseImpl
import com.ankitdev.imagestory.domain.ImagesRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 *<h1>UseCaseModule class</h1>

 *<p>Dagger module.</p>

 * @author : Ankit
 * @since : 15 Feb 2020
 * @version : 1.0
 */
@Module
class UseCaseModule {

    @Singleton
    @Provides
    fun provideImageUseCase(imagesRepository: ImagesRepository): GetImageUseCase {
        return GetImageUseCaseImpl(imagesRepository)
    }
}