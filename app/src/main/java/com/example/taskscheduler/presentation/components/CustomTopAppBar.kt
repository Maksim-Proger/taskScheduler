package com.example.taskscheduler.presentation.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.TopAppBarScrollBehavior
import androidx.compose.runtime.Composable

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CustomTopAppBar(
    title: String,
    homeButtonIsNotNeeded: Boolean,
    descriptionIconButton: String = "",
    scrollBehavior: TopAppBarScrollBehavior,
    buttonOpenNavigationDrawer: () -> Unit = {},
    buttonSwitchToAnotherScreen: () -> Unit = {}
) {
    TopAppBar(
        scrollBehavior = scrollBehavior,
        title = {
            Text(
                text = title,
                style = MaterialTheme.typography.headlineLarge
            )
        },
        actions = {
            if (homeButtonIsNotNeeded) {
                IconButton(
                    onClick = buttonSwitchToAnotherScreen
                ) {
                    Icon(
                        imageVector = Icons.Default.Home,
                        contentDescription = descriptionIconButton,
                        tint = MaterialTheme.colorScheme.onPrimary
                    )
                }
            }
        },
        navigationIcon = {
            IconButton(
                onClick = buttonOpenNavigationDrawer
            ) {
                Icon(
                    Icons.Default.Menu, contentDescription = "Меню"
                )
            }
        },
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = MaterialTheme.colorScheme.primary,
            titleContentColor = MaterialTheme.colorScheme.onPrimary
        )
    )
}

