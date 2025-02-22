package com.example.taskscheduler.presentation.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.taskscheduler.domain.usecase.firebase.LoginUserUseCase
import com.example.taskscheduler.domain.usecase.firebase.LogoutUserUseCase
import com.example.taskscheduler.domain.usecase.firebase.RegisterUserUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FireBaseViewModel @Inject constructor(
    private val registerUserUseCase: RegisterUserUseCase,
    private val loginUserUseCase: LoginUserUseCase,
    private val logoutUserUseCase: LogoutUserUseCase
): ViewModel() {

    fun registerUser(email: String, password: String) {
        viewModelScope.launch {
            try {
                registerUserUseCase(email, password)
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }

    fun loginUser(email: String, password: String) {
        viewModelScope.launch {
            try {
                loginUserUseCase(email, password)
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }

    fun logout() {
        viewModelScope.launch {
            try {
                logoutUserUseCase()
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }

}