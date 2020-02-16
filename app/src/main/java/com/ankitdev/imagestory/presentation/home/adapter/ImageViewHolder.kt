package com.ankitdev.imagestory.presentation.home.adapter

import androidx.recyclerview.widget.RecyclerView
import com.ankitdev.imagestory.R
import com.ankitdev.imagestory.data.model.ImageData
import com.ankitdev.imagestory.databinding.ItemGridImageBinding
import com.bumptech.glide.Glide

/**
 *<h1></h1>

 *<p></p>

 * @author : Ankit
 * @since : 16 Feb 2020
 * @version : 1.0
 * @company : 3Embed Software Technologies Pvt. Ltd.
 */
class ImageViewHolder constructor(
    private val binding: ItemGridImageBinding,
    private val onClickListener: (any: Any) -> Unit
) :
    RecyclerView.ViewHolder(binding.root) {

    private lateinit var imageData: ImageData

    fun bind(imageData: ImageData) {
        this.imageData = imageData
        binding.imageData = imageData
        binding.root.setOnClickListener { onClickListener.invoke(imageData) }
        if (imageData.images != null&& imageData.images.isNotEmpty()) {
            Glide.with(binding.root).load(
                imageData.images[0].link
            ).centerCrop().placeholder(R.drawable.splash_logo).into(binding.ivImage)
        }
    }

}