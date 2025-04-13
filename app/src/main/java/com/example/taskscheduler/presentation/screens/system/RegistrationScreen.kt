package com.example.taskscheduler.presentation.screens.system

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Done
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FabPosition
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.taskscheduler.R
import com.example.taskscheduler.presentation.components.CustomFloatingButton
import com.example.taskscheduler.presentation.components.CustomOutlinedTextField
import com.example.taskscheduler.presentation.components.CustomTopAppBar
import com.example.taskscheduler.presentation.navigation.Route
import com.example.taskscheduler.presentation.theme.TaskSchedulerTheme
import com.example.taskscheduler.presentation.viewmodels.AuthenticationViewModel
import com.example.taskscheduler.utils.navigateFunction

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RegistrationScreen(
    navController: NavHostController,
    authenticationViewModel: AuthenticationViewModel = hiltViewModel()
) {

    val (name, setName) = remember { mutableStateOf("") }
    val (email, setEmail) = remember { mutableStateOf("") }
    val (password, setPassword) = remember { mutableStateOf("") }

    val scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior()
    val keyboardController = LocalSoftwareKeyboardController.current
    val focusManager = LocalFocusManager.current

    // Состояние результата регистрации
    val registrationResult by authenticationViewModel.authResult.collectAsState()
    val isLoading by authenticationViewModel.isLoading.collectAsState()

    // Обработка результата регистрации
    LaunchedEffect(registrationResult) {
        registrationResult?.let {
            if (it.isSuccess) {
                navigateFunction(navController, Route.LoginScreen.route)
            } else {
                val errorMessage = it.exceptionOrNull()?.message
                println("Registration failed: $errorMessage")
            }

            authenticationViewModel.resetAuthResult()
        }
    }

    Scaffold(
        topBar = {
            CustomTopAppBar(
                title = stringResource(R.string.title_app_registration_screen),
                scrollBehavior = scrollBehavior
            )
        },
        floatingActionButton = {
            CustomFloatingButton(
                imageIcon = Icons.Default.Done,
                contentDescription = "",
                textFloatingButton = stringResource(R.string.button_save_for_registration_screen),
                expanded = true,
                onButtonClick = {
                    /*TODO: Добавить проверку данных перед сохранением*/
                    authenticationViewModel.registerUser(email, password, name)
                }
            )
        },
        floatingActionButtonPosition = FabPosition.End
    ) { innerPadding ->

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding),
            verticalArrangement = Arrangement.Center
        ) {
            CustomOutlinedTextField(
                label = {
                    Text(
                        stringResource(R.string.label_name_for_registration_screen),
                        color = MaterialTheme.colorScheme.onPrimary,
                        style = MaterialTheme.typography.bodyMedium
                    )
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
            Spacer(modifier = Modifier.padding(10.dp))
            CustomOutlinedTextField(
                label = {
                    Text(
                        stringResource(R.string.label_email_for_registration_screen),
                        color = MaterialTheme.colorScheme.onPrimary,
                        style = MaterialTheme.typography.bodyMedium
                    )
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
            Spacer(modifier = Modifier.padding(10.dp))
            CustomOutlinedTextField(
                label = {
                    Text(
                        stringResource(R.string.label_password_for_registration_screen),
                        color = MaterialTheme.colorScheme.onPrimary,
                        style = MaterialTheme.typography.bodyMedium
                    )
                },
                horizontalPadding = 16.dp,
                value = password,
                onValueChange = setPassword,
                keyboardActions = KeyboardActions(
                    onDone = {
                        keyboardController?.hide()
                        focusManager.clearFocus()
                    }
                ),
                keyboardType = KeyboardType.Password,
                imeAction = ImeAction.Done
            )
        }
    }
}

//@Preview(showBackground = true)
@Preview(uiMode = UI_MODE_NIGHT_YES, showBackground = true)
@Composable
fun PreviewRegistrationScreen() {
    TaskSchedulerTheme {
        val navController = rememberNavController()
        RegistrationScreen(navController)
    }
}
