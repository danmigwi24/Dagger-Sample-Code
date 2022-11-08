package com.example.daggerwithcopmose.data.repository


import com.example.daggerwithcopmose.data.network.BaseApiService
import com.example.daggerwithcopmose.data.network.responses.CommentListDataResponse
import okhttp3.RequestBody
import retrofit2.http.GET
import javax.inject.Inject

class CommonRepository @Inject constructor(
    private val api: BaseApiService,
) : BaseRepository {

    suspend fun loginUser(
        requestBody: RequestBody
    ) = apiRequestByResource {
        api.login(requestBody = requestBody)
    }

    suspend fun paymentTransactions(requestBody: RequestBody) =
        apiRequestByResource {
            api.paymentTransactions(requestBody)
        }

    fun getCommentsListData() = apiRequestByResourceFlow {
        api.getCommentsListData()
    }

}
