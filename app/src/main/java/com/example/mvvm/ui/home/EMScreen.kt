package com.example.mvvm.ui.home

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.mvvm.R
import com.example.mvvm.domain.item.EMItem
import com.example.mvvm.navigation.NavRoutes

@Composable
fun EnergyMeterScreen(navHostController: NavHostController, details: List<EMItem>, data: List<Float>) {
    Column() {
        details.forEach() { it ->
            if (it == details[details.size - 1]) {
                HomeScreen(detail = it, navHostController, data)
            }
        }
    }
}

@Composable
fun HomeScreen(detail: EMItem, navHostController: NavHostController, data: List<Float>) {
    val voltage = detail.voltage
    val current = detail.current
    val power = detail.power
    val freq = detail.frequency

    val displayList = mutableMapOf(
        "Voltage: " to voltage,
        "Current: " to current,
        "Power: " to power,
        "Frequency: " to freq
    )

    Column(
        modifier = Modifier
            .background(brush = Brush.verticalGradient(listOf(Color.Red, Color.White)))
    ) {
        Row(
            modifier = Modifier
                .padding(10.dp)
                .weight(1f)
        ) {
            DisplayCard(
                title = "Current",
                value = displayList.get("Current: ").toString(),
                R.drawable.current
            )
            DisplayCard(
                title = "Power",
                value = displayList.get("Power: ").toString(),
                R.drawable.thunderbolt
            )
        }

        Row(
            modifier = Modifier
                .padding(10.dp)
                .weight(1f)
        ) {
            DisplayCard(
                title = "Frequency",
                value = displayList.get("Frequency: ").toString(),
                R.drawable.frequency
            )
            DisplayCard(
                title = "Voltage",
                value = displayList.get("Voltage: ").toString(),
                R.drawable.voltage
            )
        }
        DisplayLineChart(navHostController = navHostController, data = data)
    }
}

@Composable
fun DisplayCard(title: String, value: String, image: Int) {
    Card(
        elevation = 10.dp,
        shape = RoundedCornerShape(15.dp),
        modifier = Modifier
            .padding(10.dp)
            .fillMaxHeight()
            .width(170.dp)
    ) {
        Column(
            modifier = Modifier.background(
                brush = Brush.verticalGradient(
                    listOf(Color(0xFFFC4F00), Color.Yellow)
                )
            ),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Image(painter = painterResource(id = image), contentDescription = null)
            Text(
                text = title,
                fontWeight = FontWeight.Bold,
                color = Color.Black,
                fontSize = 25.sp
            )
            Text(
                text = value,
                fontWeight = FontWeight.Bold,
                color = Color.Black,
                fontSize = 20.sp
            )
        }
    }
}


@Preview(showBackground = true, showSystemUi = true)
@Composable
fun Preview() {
    EnergyMeterScreen(navHostController = rememberNavController(), emptyList(), emptyList())
}


