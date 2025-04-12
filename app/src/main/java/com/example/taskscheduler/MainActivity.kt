package com.example.taskscheduler

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.taskscheduler.presentation.navigation.NavGraph
import com.example.taskscheduler.presentation.navigation.Route
import com.example.taskscheduler.presentation.screens.MainScreen
import com.example.taskscheduler.presentation.theme.TaskSchedulerTheme
import com.example.taskscheduler.presentation.viewmodels.SharedPreferencesViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val sharedPreferencesViewModel: SharedPreferencesViewModel = hiltViewModel()
            val registrationFlag by sharedPreferencesViewModel.registrationFlag.collectAsState()

            TaskSchedulerTheme {
                Surface (
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    if (registrationFlag) {
                        NavGraph(startDestination = Route.MainScreen.route)
                    } else {
                        NavGraph(startDestination = Route.LoginScreen.route)
                    }
                }
            }
        }
    }
}

