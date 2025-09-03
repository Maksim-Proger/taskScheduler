package com.example.taskscheduler.presentation.screens.system

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
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
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.taskscheduler.R
import com.example.taskscheduler.presentation.components.CustomOutlinedTextField
import com.example.taskscheduler.presentation.components.CustomTextButton
import com.example.taskscheduler.presentation.components.CustomTopAppBar
import com.example.taskscheduler.presentation.navigation.Route
import com.example.taskscheduler.presentation.theme.TaskSchedulerTheme
import com.example.taskscheduler.presentation.viewmodels.AuthenticationViewModel
import com.example.taskscheduler.presentation.viewmodels.SPViewModel
import com.example.taskscheduler.utils.navigateFunction

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginScreen(
    navController: NavHostController,
    authenticationViewModel: AuthenticationViewModel = hiltViewModel(),
    SPViewModel: SPViewModel = hiltViewModel()
) {
    val userData by authenticationViewModel.userData.collectAsState()
    val loginResult by authenticationViewModel.authResult.collectAsState()

    val (email, setEmail) = remember { mutableStateOf("") }
    val (password, setPassword) = remember { mutableStateOf("") }

    val scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior()
    val keyboardController = LocalSoftwareKeyboardController.current
    val focusManager = LocalFocusManager.current

    LaunchedEffect(loginResult) {
        loginResult?.let {
            if (it.isSuccess) {
                userData?.let { user ->
                    SPViewModel.saveUserId(user.userId)
                    SPViewModel.saveUserName(user.name)
                    SPViewModel.saveUserEmail(user.email)
                    SPViewModel.saveRegistrationFlag(true)
                    navigateFunction(navController, Route.MainScreen.route)
                }
            } else {
                val errorMessage = it.exceptionOrNull()?.message
                println("Login failed: $errorMessage")
            }
            authenticationViewModel.resetAuthResult()
        }
    }

    Scaffold(
        topBar = {
            CustomTopAppBar(
                title = stringResource(R.string.title_app_login_screen),
                scrollBehavior = scrollBehavior
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
            Spacer(Modifier.padding(16.dp))
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
            Spacer(Modifier.padding(26.dp))
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly,
                verticalAlignment = Alignment.CenterVertically
            ) {
                CustomTextButton(
                    stringResource(R.string.button_registration_for_login_screen),
                    onClickButton = {
                        navigateFunction(navController, Route.RegistrationScreen.route)
                    }
                )
                CustomTextButton(
                    stringResource(R.string.button_log_in_for_login_screen),
                    onClickButton = {
                        /*TODO: Добавить проверку данных перед входом*/
                        authenticationViewModel.loginUser(email, password)
                    }
                )
            }
        }

    }
}

@Preview(uiMode = UI_MODE_NIGHT_YES, showBackground = true)
@Composable
fun PreviewLoginScreen() {
    TaskSchedulerTheme {
        val navController = rememberNavController()
        LoginScreen(navController)
    }
}