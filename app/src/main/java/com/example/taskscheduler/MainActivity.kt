package com.example.taskscheduler

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.example.taskscheduler.presentation.navigation.NavGraph
import com.example.taskscheduler.presentation.navigation.Route
import com.example.taskscheduler.presentation.screens.MainScreen
import com.example.taskscheduler.presentation.theme.TaskSchedulerTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            TaskSchedulerTheme {
                Surface (
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
//                    NavGraph(startDestination = Route.LoginScreen.route)
                    NavGraph(startDestination = Route.MainScreen.route)
                }
            }
        }
    }
}

