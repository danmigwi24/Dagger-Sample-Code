package com.example.daggerwithcopmose.di

import android.app.Application
import com.example.daggerwithcopmose.TopApp
import dagger.Component
import dagger.android.AndroidInjectionModule
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AndroidInjectionModule::class,
        ActivityModule::class,
        AppModule::class

    ]
)
interface AppCommponent {
    fun inject(application: TopApp)
}