package com.example.daggerwithcopmose.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.daggerwithcopmose.data.network.responses.CommentListDataResponseItem
import com.example.daggerwithcopmose.ui.theme.DaggerWithCopmoseTheme
import com.example.daggerwithcopmose.ui.viemodels.HomeViewModel
import dagger.android.AndroidInjection
import javax.inject.Inject

class MainActivity : ComponentActivity() {

    // Get a reference to the ViewModel scoped to this Fragment
    //val viewModel by viewModels<HomeViewModel>()

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
                    CommentListUI(commentList = viewModel.successCommentResponse)
                    viewModel.getCommentsListDataWithCompose()
                }
            }
        }
    }
}

@Composable
fun CommentListUI(commentList: List<CommentListDataResponseItem>) {
    LazyColumn {
        itemsIndexed(items = commentList) { index, item ->
            Greeting(name = item.name.toString())
        }
    }
}

@Composable
fun Greeting(name: String) {
    Row(modifier = Modifier.padding(4.dp)) {
        Text(text = "Hello ${name}!")
    }

}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    DaggerWithCopmoseTheme {
        Greeting("Android")
    }
}