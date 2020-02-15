package com.ankitdev.imagestory.presentation.splash

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.ankitdev.imagestory.presentation.base.BaseViewModel
import com.ankitdev.imagestory.presentation.common.Constants
import com.ankitdev.imagestory.presentation.common.Event
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 *<h1></h1>

 *<p></p>

 * @author : Ankit
 * @since : 16 Feb 2020
 * @version : 1.0
 * @company : 3Embed Software Technologies Pvt. Ltd.
 */
class SplashViewModel @Inject constructor() : BaseViewModel() {

    private val _routeEvent = MutableLiveData<Event<String>>()
    val routeEvent: LiveData<Event<String>> = _routeEvent

    /**
     * Post route string to _routeEvent MutableLiveData.
     * @param route String
     */
    private fun postRouteEvent(route: String) {
        _routeEvent.postValue(Event(route))
    }

    /**
     * Wait for Splash delay time and post route to home screen.
     */
    fun initStart() {
        viewModelScope.launch {
            kotlinx.coroutines.delay(Constants.SPLASH_DELAY_MILLIS)
            postRouteEvent(Constants.HOME_PAGE)
        }
    }
}