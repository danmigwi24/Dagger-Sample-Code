package com.example.daggerwithcopmose.data.repository

import com.example.daggerwithcopmose.data.network.ApiState
import com.example.daggerwithcopmose.data.network.ResourceNetwork
import com.example.daggerwithcopmose.data.network.ResourceNetworkFlow
import com.example.daggerwithcopmose.data.network.ResourceNetworkStateFlow
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.withContext
import org.json.JSONException
import org.json.JSONObject
import retrofit2.HttpException
import timber.log.Timber
import java.io.IOException

/**
 * Wrapping network routing using
 * This help to avoid handling failure on the UI
 * Also handle how responses will be handle after success or failure
 */
interface BaseRepository {


    /**
     * Wrapping network routing using
     */
    suspend fun <T> apiRequestByResource(api: suspend () -> T): ResourceNetwork<T> {
        return withContext(Dispatchers.IO) {
            try {
                ResourceNetwork.Success(api.invoke())
            } catch (throwable: Throwable) {
                Timber.e("HttpException  throwable.message() ${throwable.message}")
                if (throwable is HttpException) {
                    Timber.e(
                        "HttpException  throwable.response() ${
                            throwable.response()
                        }"
                    )

                    // ---------------------------------------------------------------------

                    val error = throwable.response()?.errorBody()!!.string()
                    val message = StringBuilder()

                    error.let {
                        try {
                            message.append(JSONObject(it).getString("error_description"))
                        } catch (e: JSONException) {
                        }
                        message.append("\n")
                    }

                    // Timber.e("BASE REPOSITORY----->>>>>>>>>>>>>>>>>> $message")
                    // ---------------------------------------------------------------------
                    ResourceNetwork.Failure(
                        false,
                        throwable.code(),
                        throwable.response()?.errorBody(),
                        error
                    )
                } else {
                    Timber.d("HttpException ${throwable.message}")
                    Timber.d("HttpException ${throwable.cause}")
                    Timber.d("HttpException $throwable")
                    ResourceNetwork.Failure(true, null, null, "NO NETWORK FOUND")
                }
            }
        }
    }

    /**
     * Wrapping network routing using
     */
    fun <T> apiRequestByResourceFlow(api: suspend () -> T) = flow {
        try {
            emit(ResourceNetworkFlow.Loading())
            val dataResponse = api.invoke()
            emit(ResourceNetworkFlow.Success(dataResponse))
        } catch (exception: Exception) {
            emit(ResourceNetworkFlow.Error(exception))
        }
    }.flowOn(Dispatchers.IO)

    /**
     * Wrapping network routing using
     */
    fun <T> apiRequestByResourceStateFlow(api: suspend () -> T) = flow {
        try {
            emit(ResourceNetworkStateFlow.Loading)
            val dataResponse = api.invoke()
            emit(ResourceNetworkStateFlow.Success(dataResponse))
        } catch (exception: Exception) {
            emit(ResourceNetworkStateFlow.Failure(exception))
        }
    }.flowOn(Dispatchers.IO)

    /**
     * Wrapping network routing using
     */
    fun <T> apiRequestByApiStateStateFlow(api: suspend () -> T) = flow {
        try {
            emit(ApiState.Loading)
            val dataResponse = api.invoke()
            emit(ApiState.Success(dataResponse))
        } catch (exception: Exception) {
            emit(ApiState.Failure(exception))
        }
    }.flowOn(Dispatchers.IO)
}

class ApiExceptions(message: String) : IOException(message)
