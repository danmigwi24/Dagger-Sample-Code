package com.example.daggerwithcopmose.data.network.responses


import com.google.gson.annotations.SerializedName

data class CommentListDataResponseItem(
    @SerializedName("postId")
    var postId: Int?, // 1
    @SerializedName("id")
    var id: Int?, // 1
    @SerializedName("name")
    var name: String?, // id labore ex et quam laborum
    @SerializedName("email")
    var email: String?, // Eliseo@gardner.biz
    @SerializedName("body")
    var body: String? // laudantium enim quasi est quidem magnam voluptate ipsam eostempora quo necessitatibusdolor quam autem quasireiciendis et nam sapiente accusantium
)