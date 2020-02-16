package com.ankitdev.imagestory.presentation.detail

import com.ankitdev.imagestory.data.model.ImageData
import com.ankitdev.imagestory.presentation.base.BaseViewModel
import javax.inject.Inject

/**
 *<h1></h1>

 *<p></p>

 * @author : Ankit
 * @since : 16 Feb 2020
 * @version : 1.0
 *
 */
class DetailViewModel @Inject constructor() : BaseViewModel() {
    var imageData: ImageData? = null
    var imageUrl: String? = null
    fun initData(imageData: ImageData?) {
        this.imageData = imageData
        if (this.imageData != null && this.imageData!!.images != null && this.imageData!!.images!!.isNotEmpty()) {
            imageUrl = this.imageData!!.images?.get(0)?.link
        }
    }
}