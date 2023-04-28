package com.example.mvvm.ui.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.mvvm.domain.item.EMItem

@Composable
fun DisplayLineChart(navHostController: NavHostController, data : List<Float>){


    Column(
        modifier = Modifier
            .padding(16.dp),
        verticalArrangement = Arrangement.Center
    ) {
        LineChart(
            values = data,
            Brush.linearGradient(0f to Color(0xFF9336D1), 1f to Color(0x334a3097)),
            Color(0xFF9336D1),
            modifier = Modifier
                .fillMaxWidth()
                .size(250.dp, 200.dp)
                .align(CenterHorizontally)
        )
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun GraphScreenPreview(){
    DisplayLineChart(navHostController = rememberNavController(), emptyList())
}