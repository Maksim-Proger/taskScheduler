package com.example.taskscheduler.presentation.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavHostController
import com.example.taskscheduler.R
import com.example.taskscheduler.presentation.components.CustomNavigationDrawer
import com.example.taskscheduler.presentation.components.CustomTopAppBar
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TasksScreen(navController: NavHostController) {

    val scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior()

    CustomNavigationDrawer(navController) { drawerState, scope ->
        Scaffold(
            topBar = {
                CustomTopAppBar(
                    title = stringResource(R.string.title_app_tasks_screen),
                    homeButtonIsNotNeeded = false,
                    scrollBehavior = scrollBehavior,
                    buttonOpenNavigationDrawer = {
                        scope.launch { drawerState.open() }
                    }
                )
            }
        ) { innerPadding ->

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(innerPadding)
            ) {

            }

        }
    }
}