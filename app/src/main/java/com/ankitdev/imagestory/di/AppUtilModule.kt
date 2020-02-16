package com.ankitdev.imagestory.di

import androidx.databinding.ObservableArrayList
import com.ankitdev.imagestory.data.model.ImageData
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 *<h1>AppUtilModule class</h1>

 *<p>Dagger module.</p>

 * @author : Ankit
 * @since : 15 Feb 2020
 * @version : 1.0
 */
@Module
class AppUtilModule {

    @Provides
    @Singleton
    fun provideImageData(): ObservableArrayList<ImageData> {
        return ObservableArrayList()
    }
}