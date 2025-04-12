package com.example.taskscheduler.presentation.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.DrawerState
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.NavigationDrawerItemDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.taskscheduler.R
import com.example.taskscheduler.domain.models.DrawerItem
import com.example.taskscheduler.domain.models.UserData
import com.example.taskscheduler.presentation.navigation.Route
import com.example.taskscheduler.utils.navigateFunction
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@Composable
fun CustomNavigationDrawer(
    navController: NavHostController,
    content: @Composable (DrawerState, CoroutineScope) -> Unit,
//    userData: UserData
) {
    val items = listOf(
        DrawerItem(direction = Route.AccountingScreen.route, icon = Icons.Default.Star, label = stringResource(R.string.accounting)),
        DrawerItem(direction = Route.TasksScreen.route, icon = Icons.Default.Star, label = stringResource(R.string.tasks)),
        DrawerItem(direction = Route.ImportantEventsScreen.route, icon = Icons.Default.Star, label = stringResource(R.string.important_events)),
        DrawerItem(direction = Route.PasswordsScreen.route, icon = Icons.Default.Star, label = stringResource(R.string.passwords)),
    )
    var selectedItem by remember { mutableStateOf(items[0]) }
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val scope = rememberCoroutineScope()

    ModalNavigationDrawer(
        drawerState = drawerState,
        gesturesEnabled = true,
        drawerContent = {
            ModalDrawerSheet {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 64.dp),
                    contentAlignment = Alignment.CenterStart
                ) {
                    Column {
                        Text(
                            text = userData.name,
//                            style =
                        )
                        Text(
                            text = userData.email
//                            style =
                        )
                    }
                }
                items.forEach { item ->
                    NavigationDrawerItem(
                        label = { Text(text = item.label) },
                        selected = item == selectedItem,
                        onClick = {
                            navigateFunction(navController, item.direction)
                            scope.launch { drawerState.close() }
                            selectedItem = item
                        },
                        modifier = Modifier.padding(NavigationDrawerItemDefaults.ItemPadding)
                    )
                }
            }
        }
    ) {
        content(drawerState, scope)
    }
}

