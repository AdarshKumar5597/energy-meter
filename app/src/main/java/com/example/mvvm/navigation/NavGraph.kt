package com.example.mvvm.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.mvvm.ui.home.*

@Composable
fun NavGraph(navHostController: NavHostController) {
    val emViewModel = viewModel(modelClass = HomeViewModel::class.java)
    val details by emViewModel.details.collectAsState()

    val data : MutableList<Float> = mutableListOf()
    details.forEach(){
        data.add(it.power.toFloat())
    }

    NavHost(
        navController = navHostController,
        startDestination = NavRoutes.HomeRoute.route,
        builder = {

            composable(
                route = NavRoutes.HomeRoute.route,
                content = {
                    EnergyMeterScreen(navHostController, details, data)
                }
            )

            composable(
                route = NavRoutes.GraphRoute.route,
                content = {
                    DisplayLineChart(navHostController, data)
                }
            )
        }
    )
}