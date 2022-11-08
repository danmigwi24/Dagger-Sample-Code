package com.example.daggerwithcopmose.data.network


import com.example.daggerwithcopmose.data.network.responses.CommentListDataResponse
import com.example.daggerwithcopmose.data.network.responses.CommonResponse
import okhttp3.RequestBody
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
}
