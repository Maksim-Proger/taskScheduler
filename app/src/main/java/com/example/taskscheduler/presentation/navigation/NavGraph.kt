package com.example.taskscheduler.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.auth.presentation.navigation.authNavGraph
import com.example.taskscheduler.presentation.components.items.drawerItemList
import com.example.taskscheduler.presentation.screens.AccountingScreen
import com.example.taskscheduler.presentation.screens.ImportantEventsScreen
import com.example.taskscheduler.presentation.screens.MainScreen
import com.example.taskscheduler.presentation.screens.PasswordsScreen
import com.example.taskscheduler.presentation.screens.TasksScreen
import com.example.taskscheduler.presentation.screens.system.SettingsScreen
import com.example.taskscheduler.utils.navigateFunction
import com.example.ui.presentation.components.CustomNavigationDrawer
import kotlinx.coroutines.launch

@Composable
fun NavGraph(
    startDestination: String,
    userName: String? = null,
    userEmail: String? = null,
    userId: String? = null // TODO: не забыть добавить в экран
) {
    val navController = rememberNavController()
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route

    CustomNavigationDrawer(
        userName = userName,
        userEmail = userEmail,
        selectedItemRoute = currentRoute,
        items = drawerItemList(),
        onItemClick = { route ->
            navigateFunction(navController, route)
        }
    ) { drawerState, scope ->
        NavHost(
            navController = navController,
            startDestination = startDestination
        ) {
            composable(Route.MainScreen.route) {
                MainScreen(
                    navController,
                    openDrawer = { scope.launch { drawerState.open() } }
                )
            }
            composable(Route.AccountingScreen.route) {
                AccountingScreen(
                    navController,
                    openDrawer = { scope.launch { drawerState.open() } }
                )
            }
            composable(Route.ImportantEventsScreen.route) {
                ImportantEventsScreen(
                    navController,
                    openDrawer = { scope.launch { drawerState.open() } }
                )
            }
            composable(Route.PasswordsScreen.route) {
                PasswordsScreen(
                    navController,
                    openDrawer = { scope.launch { drawerState.open() } }
                )
            }
            composable(Route.TasksScreen.route) {
                TasksScreen(
                    navController,
                    openDrawer = { scope.launch { drawerState.open() } }
                )
            }
            composable(Route.SettingsScreen.route) {
                SettingsScreen(
                    navController,
                    openDrawer = { scope.launch { drawerState.open() } }
                )
            }

            // Подключаем граф из auth
            authNavGraph(
                navController = navController,
                onLoginSuccess = {
                    // при успехе → переход в главный граф
                    navigateFunction(navController, Route.MainScreen.route)
                }
            )
        }
    }

}
