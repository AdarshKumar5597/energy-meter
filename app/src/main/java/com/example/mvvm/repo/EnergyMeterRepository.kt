package com.example.mvvm.repo

import com.example.mvvm.data.remote.EnergyMeterService
import com.example.mvvm.data.remote.model.DataModel
import com.example.mvvm.domain.item.EMItem
import com.example.mvvm.domain.item.toEMItem
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import java.util.concurrent.Flow
import javax.inject.Inject

class EnergyMeterRepository @Inject constructor(private val energyMeterService: EnergyMeterService) {
    suspend fun getEnergyMeterItem() : List<EMItem> {
        return energyMeterService.getEnergyMeterDetails().map {
            it.toEMItem()
        }
    }
}