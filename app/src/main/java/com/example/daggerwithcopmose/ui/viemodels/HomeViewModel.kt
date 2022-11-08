package com.example.daggerwithcopmose.ui.viemodels

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope

import com.example.daggerwithcopmose.data.network.ApiState
import com.example.daggerwithcopmose.data.network.ResourceNetwork
import com.example.daggerwithcopmose.data.network.ResourceNetworkStateFlow
import com.example.daggerwithcopmose.data.network.responses.CommentListDataResponse
import com.example.daggerwithcopmose.data.repository.CommonRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch
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


}
