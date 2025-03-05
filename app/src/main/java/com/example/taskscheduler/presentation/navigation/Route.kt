package com.example.taskscheduler.presentation.navigation

sealed class Route(
    val route: String
) {
    data object MainScreen : Route(route = "main_screen")
    data object LoginScreen : Route(route = "login_screen")
    data object RegistrationScreen : Route(route = "registration_screen")
    data object AccountingScreen : Route(route = "accounting_screen")
}