package com.example.auth.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.auth.domain.repository.system.UserPreferences
import com.example.auth.domain.usecase.system.ClearUserDataUseCase
import com.example.auth.domain.usecase.system.GetRegistrationFlagUseCase
import com.example.auth.domain.usecase.system.GetUserEmailUseCase
import com.example.auth.domain.usecase.system.GetUserIdUseCase
import com.example.auth.domain.usecase.system.GetUserNameUseCase
import com.example.auth.domain.usecase.system.SaveRegistrationFlagUseCase
import com.example.auth.domain.usecase.system.SaveUserEmailUseCase
import com.example.auth.domain.usecase.system.SaveUserIdUseCase
import com.example.auth.domain.usecase.system.SaveUserNameUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SPViewModel @Inject constructor(
    private val saveRegistrationFlagUseCase: SaveRegistrationFlagUseCase,
    private val getRegistrationFlagUseCase: GetRegistrationFlagUseCase,
    private val saveUserIdUseCase: SaveUserIdUseCase,
    private val getUserIdUseCase: GetUserIdUseCase,
    private val saveUserNameUseCase: SaveUserNameUseCase,
    private val getUserNameUseCase: GetUserNameUseCase,
    private val saveUserEmailUseCase: SaveUserEmailUseCase,
    private val getUserEmailUseCase: GetUserEmailUseCase,
    private val clearUserDataUseCase: ClearUserDataUseCase
) : ViewModel(), UserPreferences {

    private val _userId = MutableStateFlow<String?>(null)
    override val userId = _userId.asStateFlow()

    private val _userName = MutableStateFlow<String?>(null)
    override val userName = _userName.asStateFlow()

    private val _userEmail = MutableStateFlow<String?>(null)
    override val userEmail = _userEmail.asStateFlow()

    private val _registrationFlag = MutableStateFlow(false)
    override val registrationFlag = _registrationFlag.asStateFlow()

    init { loadInitialValues() }

    private fun loadInitialValues() {
        // Инициализация состояния сразу при старте
        viewModelScope.launch {
            _registrationFlag.value = runCatching { getRegistrationFlagUseCase() }.getOrDefault(false)
            _userId.value = runCatching { getUserIdUseCase() }.getOrNull()
            _userName.value = runCatching { getUserNameUseCase() }.getOrNull()
            _userEmail.value = runCatching { getUserEmailUseCase() }.getOrNull()
        }
    }

    override fun saveRegistrationFlag(flag: Boolean) {
        viewModelScope.launch {
            runCatching { saveRegistrationFlagUseCase(flag) }
        }
    }
    override fun saveUserId(id: String) {
        viewModelScope.launch {
            runCatching { saveUserIdUseCase(id) }
        }
    }
    override fun saveUserName(name: String) {
        viewModelScope.launch {
            runCatching { saveUserNameUseCase(name) }
        }
    }
    override fun saveUserEmail(email: String) {
        viewModelScope.launch {
            runCatching { saveUserEmailUseCase(email) }
        }
    }
    fun clearUserData() {
        viewModelScope.launch {
            runCatching { clearUserDataUseCase() }
            _registrationFlag.value = false
            _userId.value = null
            _userName.value = null
            _userEmail.value = null
        }
    }

}