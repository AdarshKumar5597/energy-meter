package com.example.mvvm.di

import com.example.mvvm.data.remote.EnergyMeterApi
import com.example.mvvm.util.Constants.Companion.BASE_URL
import com.google.gson.Gson
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RetrofitModule {
    @Singleton
    @Provides
    fun provideRetrofit(): Retrofit{
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
    @Singleton
    @Provides
    fun provideEnergyMeterApi(retrofit: Retrofit) : EnergyMeterApi{
        return retrofit.create(EnergyMeterApi::class.java)
    }
}