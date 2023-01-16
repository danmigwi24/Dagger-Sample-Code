package com.example.daggerwithcopmose.data.model

sealed class OrderType {
    object Ascending:OrderType()
    object Descending:OrderType()
}