package com.ankitdev.imagestory

import com.ankitdev.imagestory.di.DaggerAppComponent
import dagger.android.AndroidInjector
import dagger.android.support.DaggerApplication

/**
 *<h1>ImageStoryApplication class</h1>

 *<p>App application class</p>

 * @author : Ankit
 * @since : 15 Feb 2020
 * @version : 1.0
 */
class ImageStoryApplication : DaggerApplication() {

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        val appComponent = DaggerAppComponent.builder()
            .application(this)
            .build()
        appComponent.inject(this)
        return appComponent
    }

}