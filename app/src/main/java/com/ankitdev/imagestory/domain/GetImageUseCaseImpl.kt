package com.ankitdev.imagestory.domain

import com.ankitdev.imagestory.data.model.ImageData
import com.ankitdev.imagestory.data.model.ImageDataResponse
import io.reactivex.Single

/**
 *<h1></h1>

 *<p></p>

 * @author : Ankit
 * @since : 16 Feb 2020
 * @version : 1.0
 * @company : 3Embed Software Technologies Pvt. Ltd.
 */
class GetImageUseCaseImpl(
    private val imagesRepository: ImagesRepository
) : GetImageUseCase {

    override fun getImages(): Single<ImageDataResponse> {
        return imagesRepository.getImages()
    }
}