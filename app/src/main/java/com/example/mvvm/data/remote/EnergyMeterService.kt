package com.example.mvvm.data.remote

import com.example.mvvm.data.remote.model.DataModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class EnergyMeterService @Inject constructor(private val energyMeterApi: EnergyMeterApi) {
    suspend fun getEnergyMeterDetails() : List<DataModel> {
        return withContext(Dispatchers.IO){
            val emDetails = energyMeterApi.getEMDetails()
            if (emDetails.isSuccessful){
                emDetails.body()!!.data
            }else{
                emptyList()
            }
        }
    }
}