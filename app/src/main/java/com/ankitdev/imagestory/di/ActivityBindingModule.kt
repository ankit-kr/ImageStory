package com.ankitdev.imagestory.di

import com.ankitdev.imagestory.di.scope.ActivityScoped
import com.ankitdev.imagestory.presentation.home.HomeActivity
import com.ankitdev.imagestory.presentation.home.HomeUtilModule
import com.ankitdev.imagestory.presentation.splash.SplashActivity
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
}