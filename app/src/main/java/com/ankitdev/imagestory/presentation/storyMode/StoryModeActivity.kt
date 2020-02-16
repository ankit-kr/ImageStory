package com.ankitdev.imagestory.presentation.storyMode

import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.databinding.ObservableArrayList
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.ankitdev.imagestory.R
import com.ankitdev.imagestory.data.model.ImageData
import com.ankitdev.imagestory.databinding.ActivityStoryModeBinding
import com.ankitdev.imagestory.presentation.base.BaseActivity
import com.ankitdev.imagestory.presentation.common.Constants
import com.ankitdev.imagestory.presentation.storyMode.adapter.StoryModeAdapter
import javax.inject.Inject

/**
 *<h1>StoryModeActivity class</h1>

 *<p>Shows story view.</p>

 * @author : Ankit
 * @since : 16 Feb 2020
 * @version : 1.0
 *
 */
class StoryModeActivity : BaseActivity() {
    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    @Inject
    lateinit var imageDataList: ObservableArrayList<ImageData>
    @Inject
    lateinit var storyModeAdapter: StoryModeAdapter

    var storyPosition: Int = 0  //default position

    private val viewModel: StoryModeViewModel by lazy {
        ViewModelProviders.of(this, viewModelFactory)[StoryModeViewModel::class.java]
    }
    private lateinit var binding: ActivityStoryModeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_story_mode)
        binding.viewModel = viewModel
        initView()
        setupObserver()
    }

    /**
     * Observe the route event from SplashViewModel.
     */
    private fun setupObserver() {
        viewModel.routeEvent.observe(this, Observer {
            when (it.getContentIfNotHandled()?.first) {
                Constants.CLOSE_PAGE -> {
                    finish()
                }
                Constants.NEXT_STORY -> {
                    binding.viewPager2Images.setCurrentItem(viewModel.storyPosition, true)
                }
                Constants.PREVIOUS_STORY -> {
                    binding.viewPager2Images.setCurrentItem(viewModel.storyPosition, true)
                }
            }
        })
    }


    /**
     * Initialize viewPager2
     */
    private fun initView() {
        binding.viewPager2Images.adapter = storyModeAdapter
        storyModeAdapter.onItemClickListener = {}

        binding.storiesProgressView.setStoriesCount(imageDataList.size) // <- set stories
        binding.storiesProgressView.setStoryDuration(Constants.STORY_DURATION) // <- set a story duration
        binding.storiesProgressView.setStoriesListener(viewModel) // <- set listener
        binding.storiesProgressView.startStories() // <- start progress

    }
}
