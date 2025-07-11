package com.example.taskscheduler.presentation.components.items

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBalance
import androidx.compose.material.icons.filled.Password
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.filled.Task
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import com.example.taskscheduler.R
import com.example.taskscheduler.domain.models.DrawerItem
import com.example.taskscheduler.presentation.navigation.Route

@Composable
fun drawerItemList(): List<DrawerItem> {
    return listOf(
        DrawerItem(
            direction = Route.AccountingScreen.route,
            icon = Icons.Default.AccountBalance,
            label = stringResource(R.string.accounting)
        ),
        DrawerItem(
            direction = Route.TasksScreen.route,
            icon = Icons.Default.Task,
            label = stringResource(R.string.tasks)
        ),
        DrawerItem(
            direction = Route.ImportantEventsScreen.route,
            icon = Icons.Default.Star,
            label = stringResource(R.string.important_events)
        ),
        DrawerItem(
            direction = Route.PasswordsScreen.route,
            icon = Icons.Default.Password,
            label = stringResource(R.string.passwords)
        ),
        DrawerItem(
            direction = Route.SettingsScreen.route,
            icon = Icons.Default.Settings,
            label = stringResource(R.string.settings)
        ),
    )
}