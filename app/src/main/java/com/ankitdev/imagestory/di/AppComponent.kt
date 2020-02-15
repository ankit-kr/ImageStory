package com.ankitdev.imagestory.di

import com.ankitdev.imagestory.ImageStoryApplication
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

/**
 *<h1>AppComponent class</h1>

 *<p>Dagger Component class which fulfill the app dependency using Dagger Module.</p>

 * @author : Ankit
 * @since : 15 Feb 2020
 * @version : 1.0
 */
@Singleton
@Component(
    modules = [AppModule::class,
        AppUtilModule::class,
        NetworkModule::class,
        ViewModelModule::class,
        RepositoryModule::class,
        UseCaseModule::class,
        ActivityBindingModule::class,
        AndroidSupportInjectionModule::class]
)
interface AppComponent : AndroidInjector<ImageStoryApplication> {

    override fun inject(instance: ImageStoryApplication?)

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(imageStoryApplication: ImageStoryApplication): Builder

        fun build(): AppComponent
    }
}