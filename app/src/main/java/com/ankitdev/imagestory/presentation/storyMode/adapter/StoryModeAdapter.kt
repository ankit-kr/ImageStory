package com.ankitdev.imagestory.presentation.storyMode.adapter

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
 * @since : 17 Feb 2020
 * @version : 1.0
 *
 */
class StoryModeAdapter(imageDataList: ObservableArrayList<ImageData>) :
    ObservableRecyclerViewAdapter<ImageData, StoryModeViewHolder>(imageDataList) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StoryModeViewHolder {
        return StoryModeViewHolder(
            DataBindingUtil.inflate(LayoutInflater.from(parent.context),
                R.layout.item_story_mode,parent,false)
        )
    }

    override fun onBindViewHolder(holder: StoryModeViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

}