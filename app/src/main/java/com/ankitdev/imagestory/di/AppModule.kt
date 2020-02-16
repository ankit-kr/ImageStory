package com.ankitdev.imagestory.di

import android.content.Context
import com.ankitdev.imagestory.ImageStoryApplication
import dagger.Binds
import dagger.Module
import javax.inject.Singleton

/**
 *<h1>AppModule class</h1>

 *<p>Dagger module.</p>

 * @author : Ankit
 * @since : 15 Feb 2020
 * @version : 1.0
 */
@Module
abstract class AppModule {

    @Singleton
    @Binds
    abstract fun bindContext(imageStoryApplication: ImageStoryApplication): Context
}