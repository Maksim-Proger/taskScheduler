package com.example.taskscheduler.presentation.screens

import com.example.taskscheduler.R
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.taskscheduler.presentation.components.CustomOutlinedTextField
import com.example.taskscheduler.presentation.components.CustomTopAppBar
import com.example.taskscheduler.presentation.theme.TaskSchedulerTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginScreen() {

    val (email, setEmail) = remember { mutableStateOf("") }
    val (password, setPassword) = remember { mutableStateOf("") }

    val scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior()
    val keyboardController = LocalSoftwareKeyboardController.current
    val focusManager = LocalFocusManager.current

    Scaffold(
        topBar = {
            CustomTopAppBar(
                title = stringResource(R.string.title_log_in_to_the_app),
                titleButton = stringResource(R.string.registration_button),
                scrollBehavior = scrollBehavior,
                buttonSwitchToAnotherScreen = {
                    // TODO: Настроить навигацию
                }
            )
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            CustomOutlinedTextField(
                horizontalPadding = 16.dp,
                value = email,
                onValueChange = setEmail,
                keyboardActions = KeyboardActions(
                    onNext = {
                        focusManager.moveFocus(FocusDirection.Next)
                    }
                ),
                keyboardType = KeyboardType.Email,
                imeAction = ImeAction.Next
            )
            Spacer(Modifier.padding(16.dp))
            CustomOutlinedTextField(
                horizontalPadding = 16.dp,
                value = password,
                onValueChange = setPassword,
                keyboardActions = KeyboardActions(
                    onDone = {
                        keyboardController?.hide() // TODO: Переделать действие
                    }
                ),
                keyboardType = KeyboardType.Password,
                imeAction = ImeAction.Done
            )
        }

    }
}

@Preview
@Composable
fun PreviewLoginScreen() {
    TaskSchedulerTheme {
        LoginScreen()
    }
}