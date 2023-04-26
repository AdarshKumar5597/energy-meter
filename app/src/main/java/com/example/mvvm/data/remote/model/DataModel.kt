package com.example.mvvm.data.remote.model

data class DataModel(
    val id: Int,
    val current: String,
    val date_created: String,
    val frequency: String,
    val power: String,
    val power_factor: String?,
    val voltage: String
)