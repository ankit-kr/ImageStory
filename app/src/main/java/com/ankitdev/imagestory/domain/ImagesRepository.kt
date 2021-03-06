package com.ankitdev.imagestory.domain

import com.ankitdev.imagestory.data.model.ImageDataResponse
import io.reactivex.Single

/**
 *<h1></h1>

 *<p></p>

 * @author : Ankit
 * @since : 16 Feb 2020
 * @version : 1.0
 *
 */
interface ImagesRepository {

    fun getImages(): Single<ImageDataResponse>
}