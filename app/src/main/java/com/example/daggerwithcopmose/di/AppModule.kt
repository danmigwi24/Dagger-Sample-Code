package com.example.daggerwithcopmose.di

import android.content.Context
import com.example.daggerwithcopmose.TopApp
import com.example.daggerwithcopmose.data.network.BaseApiService
import com.example.daggerwithcopmose.data.network.NetworkInterceptor
import com.example.daggerwithcopmose.data.network.RemoteDataSource
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule(
     private val context: Context
) {
/*    @Singleton
    @Provides
    fun provideContext(app: TopApp): Context {
        return app
    }*/

    @Singleton
    @Provides
    fun provideNetworkInterceptor(): NetworkInterceptor {
        return NetworkInterceptor(context)
    }

    @Singleton
    @Provides
    fun provideRemoteDataSource(networkInterceptor: NetworkInterceptor): RemoteDataSource {
        return RemoteDataSource(networkInterceptor)
    }

    @Singleton
    @Provides
    fun provideApiService(remoteDataSource: RemoteDataSource) =
        remoteDataSource.buildApi(BaseApiService::class.java)


}