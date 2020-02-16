package com.ankitdev.imagestory.presentation.storyMode

import androidx.databinding.ObservableArrayList
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.ankitdev.imagestory.data.model.ImageData
import com.ankitdev.imagestory.presentation.base.BaseViewModel
import com.ankitdev.imagestory.presentation.common.Constants.CLOSE_PAGE
import com.ankitdev.imagestory.presentation.common.Constants.NEXT_STORY
import com.ankitdev.imagestory.presentation.common.Constants.PREVIOUS_STORY
import com.ankitdev.imagestory.presentation.common.Event
import jp.shts.android.storiesprogressview.StoriesProgressView
import javax.inject.Inject

/**
 *<h1></h1>

 *<p></p>

 * @author : Ankit
 * @since : 16 Feb 2020
 * @version : 1.0
 *
 */
class StoryModeViewModel @Inject constructor(
    private val imageDataList: ObservableArrayList<ImageData>
) : BaseViewModel(), StoriesProgressView.StoriesListener {


    private val _routeEvent = MutableLiveData<Event<Pair<String, *>>>()
    val routeEvent: LiveData<Event<Pair<String, *>>> = _routeEvent

    var storyPosition: Int = 0  //default position

    /**
     * Post route string to _routeEvent MutableLiveData.
     * @param pair Pair<String,*>
     */
    private fun postRouteEvent(pair: Pair<String, *>) {
        _routeEvent.postValue(Event(pair))
    }

    override fun onComplete() {
        postRouteEvent(Pair(CLOSE_PAGE, ""))
    }

    override fun onPrev() {
        storyPosition -= 1
        if (storyPosition < 0) {
            storyPosition = 0
        }
        postRouteEvent(Pair(PREVIOUS_STORY, ""))
    }

    override fun onNext() {
        storyPosition += 1
        if (storyPosition > imageDataList.size - 1) {
            storyPosition = imageDataList.size - 1
        }
        postRouteEvent(Pair(NEXT_STORY, ""))
    }
}