package com.ankitdev.imagestory.presentation.home

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.databinding.ObservableArrayList
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.ankitdev.imagestory.R
import com.ankitdev.imagestory.data.model.ImageData
import com.ankitdev.imagestory.databinding.ActivityHomeBinding
import com.ankitdev.imagestory.presentation.base.BaseActivity
import com.ankitdev.imagestory.presentation.common.Constants
import com.ankitdev.imagestory.presentation.common.Constants.DETAIL_PAGE
import com.ankitdev.imagestory.presentation.common.Constants.IMAGE_DATA
import com.ankitdev.imagestory.presentation.common.Constants.STORY_MODE_PAGE
import com.ankitdev.imagestory.presentation.detail.DetailActivity
import com.ankitdev.imagestory.presentation.home.adapter.ImageAdapter
import com.ankitdev.imagestory.presentation.storyMode.StoryModeActivity
import javax.inject.Inject

/**
 *<h1>HomeActivity class</h1>

 *<p>Shows story view.</p>

 * @author : Ankit
 * @since : 16 Feb 2020
 * @version : 1.0
 *
 */
class HomeActivity : BaseActivity() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    @Inject
    lateinit var imageDataList: ObservableArrayList<ImageData>
    @Inject
    lateinit var imageAdapter: ImageAdapter

    private val viewModel: HomeViewModel by lazy {
        ViewModelProviders.of(this, viewModelFactory)[HomeViewModel::class.java]
    }
    private lateinit var binding: ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_home)
        binding.viewModel = viewModel
        initData()
        initView()
        setupObserver()
    }

    /**
     * Observe the route event from SplashViewModel.
     */
    private fun setupObserver() {
        viewModel.routeEvent.observe(this, Observer {
            when (it.getContentIfNotHandled()?.first) {
                DETAIL_PAGE -> {
                    val data = it.getContent().second
                    if (data != null)
                        launchDetailScreen(data as ImageData)
                }
                STORY_MODE_PAGE -> {
                    launchStoryModeScreen()
                }
                Constants.TOAST_MESSAGE -> {
                    Toast.makeText(this, it.getContent().second.toString(), Toast.LENGTH_SHORT)
                        .show()
                }
            }
        })
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater: MenuInflater = MenuInflater(this)
        inflater.inflate(R.menu.home_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.action_story_mode -> {
                viewModel.onStoryModeButtonClicked()
            }
        }
        return super.onOptionsItemSelected(item)
    }

    /**
     * Launch detail screen.
     */
    private fun launchDetailScreen(imageData: ImageData) {
        val intent = Intent(this, DetailActivity::class.java)
        intent.putExtra(IMAGE_DATA, imageData)
        intent.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT)
        startActivity(intent)
    }

    /**
     * Launch detail screen.
     */
    private fun launchStoryModeScreen() {
        val intent = Intent(this, StoryModeActivity::class.java)
        intent.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT)
        startActivity(intent)
    }

    /**
     * Initialize recyclerView.
     */
    private fun initView() {
        setSupportActionBar(binding.toolbar)

        binding.rvImages.layoutManager =
            StaggeredGridLayoutManager(Constants.SPAN_COUNT, StaggeredGridLayoutManager.VERTICAL)
        binding.rvImages.itemAnimator = DefaultItemAnimator()
        binding.rvImages.setHasFixedSize(true)
        binding.rvImages.adapter = imageAdapter
        imageAdapter.onItemClickListener = { viewModel.onImageItemClick(it as ImageData) }
    }

    /**
     * Initialize image data list.
     */
    private fun initData() {
        viewModel.initData(imageDataList)
    }
}
