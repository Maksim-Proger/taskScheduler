package com.example.taskscheduler.presentation.viewmodels

import androidx.lifecycle.ViewModel
import com.example.taskscheduler.domain.usecase.system.ClearUserDataUseCase
import com.example.taskscheduler.domain.usecase.system.GetRegistrationFlagUseCase
import com.example.taskscheduler.domain.usecase.system.GetUserIdUseCase
import com.example.taskscheduler.domain.usecase.system.SaveRegistrationFlagUseCase
import com.example.taskscheduler.domain.usecase.system.SaveUserIdUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class SharedPreferencesViewModel @Inject constructor(
    private val saveRegistrationFlagUseCase: SaveRegistrationFlagUseCase,
    private val getRegistrationFlagUseCase: GetRegistrationFlagUseCase,
    private val saveUserIdUseCase: SaveUserIdUseCase,
    private val getUserIdUseCase: GetUserIdUseCase,
    private val clearUserDataUseCase: ClearUserDataUseCase
) : ViewModel() {

    private val _userId = MutableStateFlow<String?>(null)
    val userId = _userId.asStateFlow()

    private val _registrationFlag = MutableStateFlow(false)
    val registrationFlag = _registrationFlag.asStateFlow()

    init {
        getUserId()
        getRegistrationFlag()
    }

    fun saveRegistrationFlag(registrationFlag: Boolean) {
        try {
            saveRegistrationFlagUseCase(registrationFlag)
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    private fun getRegistrationFlag() {
        try {
            val flag = getRegistrationFlagUseCase()
            _registrationFlag.value = flag
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    fun saveUserId(userId: String) {
        try {
            saveUserIdUseCase(userId)
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    private fun getUserId() {
        try {
            val id = getUserIdUseCase()
            _userId.value = id
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    fun clearUserData() {
        try {

        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

}