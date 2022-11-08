package com.example.daggerwithcopmose.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.lifecycleScope
import com.example.daggerwithcopmose.R
import com.example.daggerwithcopmose.data.network.ResourceNetworkFlow
import com.example.daggerwithcopmose.databinding.ActivitySplashBinding
import com.example.daggerwithcopmose.ui.viemodels.HomeViewModel
import dagger.android.AndroidInjection
import kotlinx.coroutines.launch
import timber.log.Timber
import javax.inject.Inject

class SplashActivity : AppCompatActivity() {
    @Inject
    lateinit var viewModel: HomeViewModel

    private lateinit var binding: ActivitySplashBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_splash)
        binding = ActivitySplashBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setUpRecyclerView()
    }

    fun setUpRecyclerView() {

        lifecycleScope.launch {
            viewModel.getCommentsListData().collect { resources ->
                when (resources) {
                    is ResourceNetworkFlow.Loading -> {
                        Timber.tag("").e("Please wait...")
                    }

                    is ResourceNetworkFlow.Success -> {
                        binding.textView.text = resources.data.toString()
                        Timber.e("Success")
                    }
                    is ResourceNetworkFlow.Error -> {

                        Timber.e("Error")

                    }
                    else -> {
                        Timber.e("else")

                    }
                }
            }
        }
    }
}