package com.example.daggerwithcopmose.data.network.request

import com.google.gson.annotations.SerializedName



data class CommonRequest(
    @SerializedName("national_id")
    var nationalId: String, // 12345
    @SerializedName("amount")
    var amount: String?, // 23000
    @SerializedName("phonenumber")
    var phonenumber: String? // 2250703035850
)
