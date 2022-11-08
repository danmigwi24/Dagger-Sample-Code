package com.example.daggerwithcopmose.utils


import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import kotlinx.coroutines.*

object Coroutines {

    fun main(work: suspend (() -> Unit)) =
        CoroutineScope(Dispatchers.Main).launch {
            work()
        }

    fun io(work: suspend (() -> Unit)) =
        CoroutineScope(Dispatchers.IO).launch {
            work()
        }


}

