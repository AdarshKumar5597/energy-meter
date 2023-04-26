package com.example.mvvm.ui.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mvvm.domain.GetEMUseCase
import com.example.mvvm.domain.item.EMItem
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(private val getEMUseCase: GetEMUseCase) : ViewModel(){
    private val _emState = MutableStateFlow(emptyList<EMItem>())
    val details: StateFlow<List<EMItem>>  get() = _emState

    init {
        getDetails()
    }

    private fun getDetails() {
        viewModelScope.launch {
            try {
                val details = getEMUseCase()
                _emState.value = details
            }
            catch (_: Exception){}
        }
    }
}