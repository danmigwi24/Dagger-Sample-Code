package com.example.daggerwithcopmose

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.lifecycleScope
import com.example.daggerwithcopmose.data.network.ResourceNetworkFlow
import com.example.daggerwithcopmose.ui.theme.DaggerWithCopmoseTheme
import com.example.daggerwithcopmose.ui.viemodels.HomeViewModel
import com.example.daggerwithcopmose.utils.toast
import dagger.android.AndroidInjection
import kotlinx.coroutines.launch
import timber.log.Timber
import javax.inject.Inject

class MainActivity : ComponentActivity() {

    @Inject
    lateinit var viewModel: HomeViewModel
    var result: String = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        setContent {
            DaggerWithCopmoseTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    val ctx = LocalContext.current
                    ctx.toast(setUpRecyclerView())
                    Timber.e(setUpRecyclerView())
                    Greeting(setUpRecyclerView())
                }
            }
        }
    }

    private fun setUpRecyclerView(): String {
        lifecycleScope.launch {
            viewModel.getCommentsListData().collect { resources ->
                when (resources) {
                    is ResourceNetworkFlow.Loading -> {
                        Timber.tag("").e("Please wait...")
                    }

                    is ResourceNetworkFlow.Success -> {
                        result = resources.data.toString()
                        Timber.e("Success ${resources.data.toString()}")
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
        Timber.e(result)
        return result
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello ${name}!")

}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    DaggerWithCopmoseTheme {
        //Greeting("Android")
    }
}