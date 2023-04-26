package com.example.mvvm.data.remote

import com.example.mvvm.data.remote.model.DataModel
import com.example.mvvm.util.Constants.Companion.EM_END_POINT
import retrofit2.Response
import retrofit2.http.GET

interface EnergyMeterApi {
    @GET(EM_END_POINT)
    suspend fun getEMDetails() : Response<List<DataModel>>
}