package com.example.taskscheduler.presentation.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.taskscheduler.domain.usecase.system.ClearUserDataUseCase
import com.example.taskscheduler.domain.usecase.system.GetRegistrationFlagUseCase
import com.example.taskscheduler.domain.usecase.system.GetUserEmailUseCase
import com.example.taskscheduler.domain.usecase.system.GetUserIdUseCase
import com.example.taskscheduler.domain.usecase.system.GetUserNameUseCase
import com.example.taskscheduler.domain.usecase.system.SaveRegistrationFlagUseCase
import com.example.taskscheduler.domain.usecase.system.SaveUserEmailUseCase
import com.example.taskscheduler.domain.usecase.system.SaveUserIdUseCase
import com.example.taskscheduler.domain.usecase.system.SaveUserNameUseCase
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
) : ViewModel() {

    private val _userId = MutableStateFlow<String?>(null)
    val userId = _userId.asStateFlow()

    private val _userName = MutableStateFlow<String?>(null)
    val userName = _userName.asStateFlow()

    private val _userEmail = MutableStateFlow<String?>(null)
    val userEmail = _userEmail.asStateFlow()

    private val _registrationFlag = MutableStateFlow(false)
    val registrationFlag = _registrationFlag.asStateFlow()

    init {
        getUserId()
        getUserName()
        getUserEmail()
        getRegistrationFlag()
    }

    fun saveRegistrationFlag(registrationFlag: Boolean) {
        viewModelScope.launch {
            try {
                saveRegistrationFlagUseCase(registrationFlag)
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }
    private fun getRegistrationFlag() {
        viewModelScope.launch {
            try {
                val flag = getRegistrationFlagUseCase()
                _registrationFlag.value = flag
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }
    fun saveUserId(userId: String) {
        viewModelScope.launch {
            try {
                saveUserIdUseCase(userId)
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }
    private fun getUserId() {
        viewModelScope.launch {
            try {
                val id = getUserIdUseCase()
                _userId.value = id
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }
    fun saveUserName(userName: String) {
        viewModelScope.launch {
            try {
                saveUserNameUseCase(userName)
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }
    private fun getUserName() {
        viewModelScope.launch {
            try {
                val name = getUserNameUseCase()
                _userName.value = name
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }
    fun saveUserEmail(userEmail: String) {
        viewModelScope.launch {
            try {
                saveUserEmailUseCase(userEmail)
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }
    private fun getUserEmail() {
        viewModelScope.launch {
            try {
                val email = getUserEmailUseCase()
                _userEmail.value = email
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }
    fun clearUserData() {
        try {

        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

}