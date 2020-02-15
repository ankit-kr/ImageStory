package com.ankitdev.imagestory.presentation.splash

import android.content.Intent
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.ankitdev.imagestory.presentation.home.HomeActivity
import com.ankitdev.imagestory.presentation.base.BaseActivity
import com.ankitdev.imagestory.presentation.common.Constants.HOME_PAGE
import javax.inject.Inject

class SplashActivity : BaseActivity() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private val viewModel: SplashViewModel by lazy {
        ViewModelProviders.of(this, viewModelFactory)[SplashViewModel::class.java]
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.initStart()
        setupObserver()
    }

    /**
     * Observe the route event from SplashViewModel.
     */
    private fun setupObserver() {
        viewModel.routeEvent.observe(this, Observer {
            when (it.getContentIfNotHandled()) {
                HOME_PAGE -> {
                    launchHomeScreen()
                }
            }
        })
    }

    /**
     * Launch home screen.
     */
    private fun launchHomeScreen() {
        val intent = Intent(this, HomeActivity::class.java)
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK)
        startActivity(intent)
    }
}
