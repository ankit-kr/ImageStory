package com.ankitdev.imagestory.data

import com.ankitdev.imagestory.BuildConfig
import com.ankitdev.imagestory.data.model.ImageDataResponse
import com.ankitdev.imagestory.domain.ImagesRepository
import io.reactivex.Single


/**
 *<h1></h1>

 *<p></p>

 * @author : Ankit
 * @since : 16 Feb 2020
 * @version : 1.0
 * @company : 3Embed Software Technologies Pvt. Ltd.
 */
class ImageRepositoryImpl(private val imageService: ImageService) : ImagesRepository {

    override fun getImages(): Single<ImageDataResponse> {
        return imageService.gallerySearch(BuildConfig.CLIENT_ID)
    }

}