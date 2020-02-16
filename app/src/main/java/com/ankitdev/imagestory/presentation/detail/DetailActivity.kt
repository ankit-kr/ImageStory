package com.ankitdev.imagestory.presentation.detail

import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.ankitdev.imagestory.R
import com.ankitdev.imagestory.data.model.ImageData
import com.ankitdev.imagestory.databinding.ActivityDetailBinding
import com.ankitdev.imagestory.presentation.base.BaseActivity
import com.ankitdev.imagestory.presentation.common.Constants
import com.bumptech.glide.Glide
import javax.inject.Inject

class DetailActivity : BaseActivity() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private val viewModel: DetailViewModel by lazy {
        ViewModelProviders.of(this, viewModelFactory)[DetailViewModel::class.java]
    }
    private lateinit var binding: ActivityDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_detail)
        binding.viewModel = viewModel
        initData()
        initView()
    }

    private fun initData() {
        viewModel.initData(intent.getParcelableExtra<ImageData>(Constants.IMAGE_DATA))
    }

    private fun initView() {
        Glide.with(this).load(viewModel.imageUrl).centerCrop().into(
            binding.ivImage
        )
    }
}
