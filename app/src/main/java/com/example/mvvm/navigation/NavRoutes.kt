package com.example.mvvm.navigation

sealed class NavRoutes(val route: String) {
    object HomeRoute : NavRoutes(route = "home-route")
    object GraphRoute : NavRoutes(route = "graph-route")
}