package com.example.taskscheduler.presentation.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FabPosition
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.taskscheduler.R
import com.example.taskscheduler.presentation.components.CustomOutlinedTextField
import com.example.taskscheduler.presentation.components.CustomTopAppBar
import com.example.taskscheduler.presentation.theme.TaskSchedulerTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RegistrationScreen() {

    val (name, setName) = remember { mutableStateOf("") }
    val (email, setEmail) = remember { mutableStateOf("") }
    val (password, setPassword) = remember { mutableStateOf("") }

    val scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior()
    val keyboardController = LocalSoftwareKeyboardController.current
    val focusManager = LocalFocusManager.current

    Scaffold(
        topBar = {
            CustomTopAppBar(
                title = stringResource(R.string.title_app_registration_screen),
                descriptionIconButton = stringResource(R.string.return_to_the_app_login_screen),
                textButtonIsNotNeeded = true,
                scrollBehavior = scrollBehavior,
                buttonSwitchToAnotherScreen = {
                    // TODO: Настроить навигацию
                }
            )
        },
        floatingActionButton = {},
        floatingActionButtonPosition = FabPosition.End
    ) { innerPadding ->

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ) {
            CustomOutlinedTextField(
                label = {
                    Text("Введите свое имя")
                },
                horizontalPadding = 16.dp,
                value = name,
                onValueChange = setName,
                keyboardActions = KeyboardActions(
                    onNext = {
                        focusManager.moveFocus(FocusDirection.Next)
                    }
                ),
                keyboardType = KeyboardType.Text,
                imeAction = ImeAction.Next
            )
            Spacer(modifier = Modifier.padding(7.dp))
            CustomOutlinedTextField(
                label = {
                    Text("Введите свой Email")
                },
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
            Spacer(modifier = Modifier.padding(7.dp))
            CustomOutlinedTextField(
                label = {
                    Text("Введите свой пароль")
                },
                horizontalPadding = 16.dp,
                value = password,
                onValueChange = setPassword,
                keyboardActions = KeyboardActions(
                    onDone = {
                        keyboardController?.hide()
                    }
                ),
                keyboardType = KeyboardType.Text,
                imeAction = ImeAction.Next
            )
        }
    }
}

@Preview
@Composable
fun PreviewRegistrationScreen() {
    TaskSchedulerTheme {
        RegistrationScreen()
    }
}
