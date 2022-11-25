package com.example.daggerwithcopmose.data.network


import com.example.daggerwithcopmose.data.network.responses.CommentListDataResponse
import com.example.daggerwithcopmose.data.network.responses.CommonResponse
import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import okhttp3.RequestBody
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST


// @todo retrofit interface, where to define all our fun

interface BaseApiService {

// LOGIN TO SYSTEM

    @POST("auth/mobileapplogin")
    suspend fun login(
        @Body requestBody: RequestBody
    ): CommonResponse

    @POST("auth/paymentTransactions")
    suspend fun paymentTransactions(
        @Body requestBody: RequestBody
    ): CommonResponse

    @GET("comments?postId=1")
    suspend fun getCommentsListData(): CommentListDataResponse


    companion object {

        fun baseApiService(): BaseApiService {

            val logging =
                HttpLoggingInterceptor().setLevel(level = HttpLoggingInterceptor.Level.BODY)
            val client: OkHttpClient = OkHttpClient.Builder()
                .addInterceptor(logging)
                .build()

            return Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(client)
                .addConverterFactory(
                    GsonConverterFactory.create(
                        GsonBuilder().serializeNulls().create()
                    )
                )
                .build()
                .create(BaseApiService::class.java)
        }
    }
}
