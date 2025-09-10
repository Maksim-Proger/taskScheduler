package com.example.auth.presentation.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.example.auth.presentation.screens.LoginScreen
import com.example.auth.presentation.screens.RegistrationScreen

fun NavGraphBuilder.authNavGraph(
    navController: NavController,
    onLoginSuccess: () -> Unit
) {
    composable(AuthRoute.LOGIN_SCREEN) {
        LoginScreen(
            navController = navController,
            onLoginSuccess = onLoginSuccess
        )
    }
    composable(AuthRoute.REGISTRATION_SCREEN) { RegistrationScreen(navController) }
}