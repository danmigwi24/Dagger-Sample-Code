package com.example.daggerwithcopmose.ui.viemodels

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope

import com.example.daggerwithcopmose.data.network.ResourceNetworkFlow
import com.example.daggerwithcopmose.data.network.responses.CommentListDataResponseItem
import com.example.daggerwithcopmose.data.repository.CommonRepository
import kotlinx.coroutines.launch
import timber.log.Timber
import javax.inject.Inject

class HomeViewModel @Inject constructor(
    private val repository: CommonRepository,
) : ViewModel() {

    private var mText: MutableLiveData<String?> = MutableLiveData()
    val text: LiveData<String?>
        get() = mText

    init {
        mText.value = "This is home fragment"
    }


    // *********************************************************************************
    fun getCommentsListData() = repository.getCommentsListData()

    var successCommentResponse: ArrayList<CommentListDataResponseItem> by mutableStateOf(arrayListOf())
    var errorCommentResponse: String by mutableStateOf("")
    fun getCommentsListDataWithCompose() {
        viewModelScope.launch {
            repository.getCommentsListData().collect { response ->
                when (response) {
                    is ResourceNetworkFlow.Loading -> {
                        Timber.tag("").e("Please wait...")
                    }
                    is ResourceNetworkFlow.Success -> {
                        successCommentResponse = response.data!!
                        Timber.e("Success ${response.data}")
                    }
                    is ResourceNetworkFlow.Error -> {
                        errorCommentResponse = response.error!!.message.toString()
                        Timber.e("Error")

                    }
                }
            }
        }
    }


}
