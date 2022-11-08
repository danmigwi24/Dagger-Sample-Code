package com.example.daggerwithcopmose.ui.viemodels

import android.Manifest
import android.app.Application
import android.content.pm.PackageManager
import android.os.Build
import android.os.Handler
import android.os.Looper
import android.telephony.TelephonyManager
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

import timber.log.Timber
import javax.inject.Inject
import kotlin.properties.Delegates

open class BaseViewModel @Inject constructor(application: Application) :
    AndroidViewModel(application) {
    protected val context
        get() = getApplication<Application>()

    var callCode: String? = null
    var shortCode: String? = null
    var transIdPassedCode by Delegates.notNull<Int>()


}
