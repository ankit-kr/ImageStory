package com.ankitdev.imagestory.presentation.home

import androidx.databinding.ObservableArrayList
import com.ankitdev.imagestory.data.model.ImageData
import com.ankitdev.imagestory.di.scope.ActivityScoped
import com.ankitdev.imagestory.presentation.home.adapter.ImageAdapter
import dagger.Module
import dagger.Provides

/**
 *<h1></h1>

 *<p></p>

 * @author : Ankit
 * @since : 16 Feb 2020
 * @version : 1.0
 *
 */
@Module
class HomeUtilModule {
    @Provides
    @ActivityScoped
    fun provideImageAdapter(imageDataList: ObservableArrayList<ImageData>): ImageAdapter {
        return ImageAdapter(imageDataList)
    }
}
