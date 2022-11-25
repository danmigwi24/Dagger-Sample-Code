package com.example.daggerwithcopmose.data.model

sealed class OrdetType {
    object Ascending:OrdetType()
    object Descending:OrdetType()
}