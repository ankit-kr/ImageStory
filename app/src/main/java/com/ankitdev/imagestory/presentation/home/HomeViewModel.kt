package com.ankitdev.imagestory.presentation.home

import android.content.Context
import android.util.Log
import androidx.databinding.ObservableArrayList
import androidx.databinding.ObservableBoolean
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.ankitdev.imagestory.R
import com.ankitdev.imagestory.data.model.ImageData
import com.ankitdev.imagestory.data.model.ImageDataResponse
import com.ankitdev.imagestory.domain.GetImageUseCase
import com.ankitdev.imagestory.presentation.base.BaseViewModel
import com.ankitdev.imagestory.presentation.common.Constants
import com.ankitdev.imagestory.presentation.common.Event
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.observers.DisposableSingleObserver
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

/**
 *<h1></h1>

 *<p></p>

 * @author : Ankit
 * @since : 16 Feb 2020
 * @version : 1.0
 *
 */
class HomeViewModel @Inject constructor(
    private val getImageUseCase: GetImageUseCase,
    private val context: Context
) : BaseViewModel() {
    companion object {
        private val TAG = HomeViewModel::class.java.simpleName
    }

    val loading = ObservableBoolean(true)

    private lateinit var imageDataList: ObservableArrayList<ImageData>

    private val _routeEvent = MutableLiveData<Event<Pair<String, *>>>()
    val routeEvent: LiveData<Event<Pair<String, *>>> = _routeEvent

    /**
     * Post route string to _routeEvent MutableLiveData.
     * @param pair Pair<String,*>
     */
    private fun postRouteEvent(pair: Pair<String, *>) {
        _routeEvent.postValue(Event(pair))
    }

    /**
     * Setter loading.
     */
    private fun setLoading(bool: Boolean) {
        this.loading.set(bool)
    }

    /**
     * Initialize necessary data to viewModel.
     */
    fun initData(imageDataList: ObservableArrayList<ImageData>) {
        this.imageDataList = imageDataList
        loadImageDataList()
    }

    private fun loadImageDataList() {
        setLoading(true)
        val disposableObserver = object : DisposableSingleObserver<ImageDataResponse>() {
            override fun onSuccess(response: ImageDataResponse) {
                handleImageSuccessResponse(response.dataList)
                Log.d(TAG, "success response")
                setLoading(false)
            }

            override fun onError(e: Throwable) {
                e.printStackTrace()
                setLoading(false)
            }

        }
        getImageUseCase.getImages().subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(disposableObserver)
    }

    private fun handleImageSuccessResponse(dataList: List<ImageData>?) {
        if (dataList != null) {
            imageDataList.clear()
            imageDataList.addAll(dataList)
        }
    }

    /**
     * On click on imageData
     *
     */
    fun onImageItemClick(imageData: ImageData) {
        postRouteEvent(Pair(Constants.DETAIL_PAGE, imageData))
    }

    /**
     * Called on story mode option clicked.
     */
    fun onStoryModeButtonClicked() {
        if (!imageDataList.isEmpty()) {
            postRouteEvent(Pair(Constants.STORY_MODE_PAGE, ""))
        }else{
            postRouteEvent(Pair(Constants.TOAST_MESSAGE, context.getString(R.string.empty_image_list)))
        }
    }
}