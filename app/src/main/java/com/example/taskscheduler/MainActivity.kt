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
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.taskscheduler.presentation.navigation.NavGraph
import com.example.taskscheduler.presentation.navigation.Route
import com.example.taskscheduler.presentation.theme.TaskSchedulerTheme
import com.example.taskscheduler.presentation.viewmodels.SPViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val SPViewModel: SPViewModel = hiltViewModel()
            val registrationFlag by SPViewModel.registrationFlag.collectAsState()

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

