package com.ankitdev.imagestory.presentation.home.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ObservableArrayList
import com.ankitdev.imagestory.R
import com.ankitdev.imagestory.data.model.ImageData
import com.ankitdev.imagestory.presentation.common.ObservableRecyclerViewAdapter

/**
 *<h1></h1>

 *<p></p>

 * @author : Ankit
 * @since : 16 Feb 2020
 * @version : 1.0
 * @company : 3Embed Software Technologies Pvt. Ltd.
 */
class ImageAdapter(private val imageDataList: ObservableArrayList<ImageData>) :
    ObservableRecyclerViewAdapter<ImageData, ImageViewHolder>(imageDataList) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageViewHolder {
        return ImageViewHolder(
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context),
                R.layout.item_grid_image,
                parent,
                false
            ),
            onItemClickListener
        )
    }

    override fun onBindViewHolder(holder: ImageViewHolder, position: Int) {
        holder.bind(imageDataList[position])
    }

}