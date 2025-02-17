package com.example.taskscheduler.utils

import androidx.navigation.NavHostController

fun navigateFunction(
    navController: NavHostController,
    route: String
) {
    navController.navigate(route) {
        popUpTo(navController.graph.startDestinationId) { saveState = true }
        launchSingleTop = true
        restoreState = true
    }
}