package com.example.daggerwithcopmose.di

import com.example.daggerwithcopmose.ui.MainActivity
import com.example.daggerwithcopmose.ui.SplashActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector


@Module
abstract class ActivityModule {

    @ContributesAndroidInjector
    abstract fun contributeMainActivity(): MainActivity

    @ContributesAndroidInjector
    abstract fun contributeSplashActivity(): SplashActivity

//    @Module
//    abstract class HomeViewModelActivityModule {
//        @Binds
//        @IntoMap
//        @ViewModelKey(HomeViewModel::class)
//        abstract fun bindHomeViewModel(viewModel: HomeViewModel): ViewModel
//    }
}