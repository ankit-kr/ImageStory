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
 * @company : 3Embed Software Technologies Pvt. Ltd.
 */
@Module
class HomeUtilModule {

    @Provides
    @ActivityScoped
    fun provideImageData(): ObservableArrayList<ImageData> {
        return ObservableArrayList()
    }

    @Provides
    @ActivityScoped
    fun provideImageAdapter(imageDataList: ObservableArrayList<ImageData>): ImageAdapter {
        return ImageAdapter(imageDataList)
    }
}
