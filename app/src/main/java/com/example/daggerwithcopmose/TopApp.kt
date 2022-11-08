package com.example.daggerwithcopmose

import android.app.Application
import com.example.daggerwithcopmose.di.AppModule
import com.example.daggerwithcopmose.di.DaggerAppCommponent
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import javax.inject.Inject

class TopApp : Application(), HasAndroidInjector {

    @Inject
    lateinit var mInjector: DispatchingAndroidInjector<Any>

    override fun onCreate() {
        super.onCreate()

        DaggerAppCommponent.builder().appModule(AppModule(this))
            .build().inject(this)
    }

    override fun androidInjector(): AndroidInjector<Any> {
       return mInjector
    }
}