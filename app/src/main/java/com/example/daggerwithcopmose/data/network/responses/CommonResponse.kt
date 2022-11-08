package com.example.daggerwithcopmose.data.network.responses

import com.google.gson.annotations.SerializedName

data class CommonResponse(
    @SerializedName("statusDescription")
    var statusDescription: String?, // Your request failed.
    @SerializedName("statusCode")
    var statusCode: Int? // 1
)
