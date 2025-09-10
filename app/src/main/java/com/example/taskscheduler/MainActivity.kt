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
import com.example.auth.domain.repository.system.UserPreferences
import com.example.auth.presentation.navigation.AuthRoute
import com.example.taskscheduler.presentation.navigation.NavGraph
import com.example.taskscheduler.presentation.navigation.Route
import com.example.ui.presentation.theme.GeneralTheme
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    @Inject
    lateinit var userPreferences: UserPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            val registrationFlag by userPreferences.registrationFlag.collectAsState()
            val userName by userPreferences.userName.collectAsState()
            val userEmail by userPreferences.userEmail.collectAsState()
            val userId by userPreferences.userId.collectAsState()

            GeneralTheme {
                Surface (
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    if (registrationFlag) {
                        NavGraph(
                            startDestination = Route.MainScreen.route,
                            userName = userName,
                            userEmail = userEmail,
                            userId = userId
                        )
                    } else {
                        NavGraph(
                            startDestination = AuthRoute.LOGIN_SCREEN
                        )
                    }
                }
            }
        }
    }
}

