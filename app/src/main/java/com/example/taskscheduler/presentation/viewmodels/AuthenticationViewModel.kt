package com.example.taskscheduler.presentation.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.taskscheduler.domain.models.UserData
import com.example.taskscheduler.domain.usecase.firebase.LoginUserUseCase
import com.example.taskscheduler.domain.usecase.firebase.LogoutUserUseCase
import com.example.taskscheduler.domain.usecase.firebase.RegisterUserUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AuthenticationViewModel @Inject constructor(
    private val registerUserUseCase: RegisterUserUseCase,
    private val loginUserUseCase: LoginUserUseCase,
    private val logoutUserUseCase: LogoutUserUseCase
): ViewModel() {

    private val _authResult = MutableStateFlow<Result<Unit>?>(null)
    val authResult = _authResult.asStateFlow()

    private val _isLoading = MutableStateFlow(false)
    val isLoading = _isLoading.asStateFlow()

    private val _userData = MutableStateFlow<UserData?>(null)
    val userData = _userData.asStateFlow()

    fun registerUser(email: String, password: String, name: String) {
        viewModelScope.launch {
            _isLoading.value = true
            try {
                registerUserUseCase(email, password, name)
                _authResult.value = Result.success(Unit) // Успешная регистрация
            } catch (e: Exception) {
                _authResult.value = Result.failure(e) // Ошибка регистрации
            } finally {
                _isLoading.value = false
            }
        }
    }

    fun loginUser(email: String, password: String) {
        viewModelScope.launch {
            _isLoading.value = true
            try {
                val user = loginUserUseCase(email, password)
                _userData.value = user
                _authResult.value = Result.success(Unit)
            } catch (e: Exception) {
                _authResult.value = Result.failure(e)
            } finally {
                _isLoading.value = false
            }
        }
    }

    fun resetAuthResult() {
        _authResult.value = null
    }

    fun logoutUser() {
        viewModelScope.launch {
            _isLoading.value = true
            try {
                logoutUserUseCase()
                _authResult.value = Result.success(Unit) // Успешный выход
            } catch (e: Exception) {
                _authResult.value = Result.failure(e) // Ошибка выхода
            } finally {
                _isLoading.value = false
            }
        }
    }

}