package com.example.mvvm.domain.item

import com.example.mvvm.data.remote.model.DataModel

data class EMItem(
    val id: Int,
    val current: String,
    val date_created: String,
    val frequency: String,
    val power: String,
    val power_factor: String?,
    val voltage: String
)

fun DataModel.toEMItem()=EMItem(id, current, date_created, frequency, power, power_factor, voltage)
