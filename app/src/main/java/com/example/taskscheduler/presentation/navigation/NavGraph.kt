package com.example.taskscheduler.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.taskscheduler.presentation.screens.AccountingScreen
import com.example.taskscheduler.presentation.screens.LoginScreen
import com.example.taskscheduler.presentation.screens.MainScreen
import com.example.taskscheduler.presentation.screens.RegistrationScreen

@Composable
fun NavGraph(startDestination: String) {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = startDestination
    ) {
        composable(Route.MainScreen.route) { MainScreen(navController) }
        composable(Route.LoginScreen.route) { LoginScreen(navController) }
        composable(Route.RegistrationScreen.route) { RegistrationScreen(navController) }
        composable(Route.AccountingScreen.route) { AccountingScreen() }
    }
}
