package com.ankitdev.imagestory.data.model

import android.os.Parcelable
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

/**
 *<h1></h1>

 *<p></p>

 * @author : Ankit
 * @since : 16 Feb 2020
 * @version : 1.0
 *
 */
data class ImageDataResponse(
    @Expose @SerializedName("data") val dataList: List<ImageData>?
)

@Parcelize
data class ImageData(
    @Expose @SerializedName("id") val id: String,
    @Expose @SerializedName("title") val title: String,
    @Expose @SerializedName("description") val description: String?,
    @Expose @SerializedName("datetime") val datetime: Long,
    @Expose @SerializedName("views") val views: Long,
    @Expose @SerializedName("ups") val ups: Long,
    @Expose @SerializedName("comment_count") val commentCount: Long,
    @Expose @SerializedName("favorite_count") val favoriteCount: Long,
    @Expose @SerializedName("images") val images: List<Images>?
) : Parcelable

@Parcelize
data class Images(
    @Expose @SerializedName("link") val link: String
) : Parcelable