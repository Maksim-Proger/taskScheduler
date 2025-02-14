package com.example.taskscheduler.presentation.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.HowToReg
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.TopAppBarScrollBehavior
import androidx.compose.runtime.Composable

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CustomTopAppBar(
    title: String,
    textButtonIsNotNeeded: Boolean,
    titleButton: String = "",
    descriptionIconButton: String = "",
    scrollBehavior: TopAppBarScrollBehavior,
    buttonSwitchToAnotherScreen: () -> Unit = {}
) {
    TopAppBar(
        scrollBehavior = scrollBehavior,
        title = {
            Text(
                text = title,
                style = MaterialTheme.typography.headlineLarge
//                color =
            )
        },
        actions = {
            if (!textButtonIsNotNeeded) {
                TextButton(
                    onClick = buttonSwitchToAnotherScreen
                ) {
                    Text(
                        text = titleButton,
                        style = MaterialTheme.typography.bodyMedium
                    )
                }
            } else {
                IconButton(
                    onClick = buttonSwitchToAnotherScreen
                ) {
                    Icon(
                        imageVector = Icons.Default.Home,
                        contentDescription = descriptionIconButton
                    )
                }
            }
        },
        colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
            // TODO: Переопределить цвет
        )
    )
}

