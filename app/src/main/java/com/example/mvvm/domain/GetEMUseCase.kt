package com.example.mvvm.domain

import com.example.mvvm.domain.item.EMItem
import com.example.mvvm.repo.EnergyMeterRepository
import javax.inject.Inject

class GetEMUseCase @Inject constructor(private val energyMeterRepository: EnergyMeterRepository){
    suspend operator fun invoke(): List<EMItem> {
        return energyMeterRepository.getEnergyMeterItem()
    }

}