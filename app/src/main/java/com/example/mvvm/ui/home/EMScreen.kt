package com.example.mvvm.ui.home

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.mvvm.data.remote.model.DataModel
import com.example.mvvm.domain.item.EMItem

@Composable
fun energyMeterScreen(){
    val emViewModel = viewModel(modelClass = HomeViewModel::class.java)
    val details by emViewModel.details.collectAsState()
    LazyColumn {
        items(details) { detail : EMItem ->
            showDetails(detail = detail)
        }
    }
}

@Composable
fun showDetails(detail: EMItem) {
    val id = detail.id
    val date = detail.date_created
    val voltage = detail.voltage
    val current = detail.current
    var pf = detail.power_factor
    val power = detail.power
    val freq = detail.frequency

    var displayList = mutableMapOf(
        "Id: " to id,
        "Date: " to date,
        "Voltage: " to voltage,
        "Current: " to current,
        "Power factor: " to pf,
        "Power: " to power,
        "Frequency: " to freq
    )

    Column(
        modifier = Modifier
            .padding(5.dp)
            .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        for(value in displayList){
            if(value.value != null){
                displayCard(title = value.key, value = value.value.toString())
            }
        }
        Spacer(modifier = Modifier.weight(1f))
    }
}

    @Composable
    fun displayCard(title : String, value : String){
        Card (
            elevation = 5.dp,
            shape = RoundedCornerShape(5.dp),
            modifier = Modifier
                .padding(5.dp)
                .fillMaxWidth()
        ){
            Row(modifier = Modifier.padding(10.dp)) {
                Text(text = title,
                    fontFamily = FontFamily.SansSerif,
                    fontWeight = FontWeight.Bold,
                    color = Color.Red
                )
                Spacer(modifier = Modifier.weight(1f))
                Text(text = value,
                    fontFamily = FontFamily.SansSerif,
                    fontWeight = FontWeight.Bold,
                    color = Color.Blue)
            }
        }
    }

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun Preview(){
    energyMeterScreen()
}


