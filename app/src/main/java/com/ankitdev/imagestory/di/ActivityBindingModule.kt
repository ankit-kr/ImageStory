package com.ankitdev.imagestory.di

import com.ankitdev.imagestory.di.scope.ActivityScoped
import com.ankitdev.imagestory.presentation.detail.DetailActivity
import com.ankitdev.imagestory.presentation.home.HomeActivity
import com.ankitdev.imagestory.presentation.home.HomeUtilModule
import com.ankitdev.imagestory.presentation.splash.SplashActivity
import com.ankitdev.imagestory.presentation.storyMode.StoryModeActivity
import com.ankitdev.imagestory.presentation.storyMode.StoryModeUtilModule
import com.ankitdev.imagestory.presentation.storyMode.StoryModeViewModel
import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 *<h1>ActivityBindingModule class</h1>

 *<p>
 *    Helps to binding Activity for dependency injection.
 *</p>

 * @author : Ankit
 * @since : 15 Feb 2020
 * @version : 1.0
 */
@Module
abstract class ActivityBindingModule {

    @ActivityScoped
    @ContributesAndroidInjector
    abstract fun splashActivity(): SplashActivity

    @ActivityScoped
    @ContributesAndroidInjector(modules = [HomeUtilModule::class])
    abstract fun homeActivity(): HomeActivity

    @ActivityScoped
    @ContributesAndroidInjector
    abstract fun deatilActivity(): DetailActivity

    @ActivityScoped
    @ContributesAndroidInjector(modules = [StoryModeUtilModule::class])
    abstract fun storyModeActivity(): StoryModeActivity
}