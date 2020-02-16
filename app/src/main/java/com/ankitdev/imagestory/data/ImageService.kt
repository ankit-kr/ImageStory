package com.ankitdev.imagestory.data

import com.ankitdev.imagestory.data.model.ImageDataResponse
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Path
import retrofit2.http.Query

/**
 *<h1></h1>

 *<p></p>

 * @author : Ankit
 * @since : 16 Feb 2020
 * @version : 1.0
 *
 */
interface ImageService {

    @GET("/3/gallery/search/{sort}/")
    fun gallerySearch(
        @Header("Authorization") auth: String,
        @Path("sort") sort: String = "top",
        @Query("q") query: String = "science and tech",
        @Query("q_type") qType: String = "jpg"
    ): Single<ImageDataResponse>
}
