package com.ankitdev.imagestory.presentation.home

import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.databinding.ObservableArrayList
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.ankitdev.imagestory.R
import com.ankitdev.imagestory.data.model.ImageData
import com.ankitdev.imagestory.databinding.ActivityHomeBinding
import com.ankitdev.imagestory.presentation.base.BaseActivity
import com.ankitdev.imagestory.presentation.common.Constants
import com.ankitdev.imagestory.presentation.home.adapter.ImageAdapter
import javax.inject.Inject

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
        imageAdapter.onItemClickListener ={viewModel.onImageItemClick(it as ImageData)}
    }

    /**
     * Initialize image data list.
     */
    private fun initData() {
        viewModel.initData(imageDataList)
    }
}
