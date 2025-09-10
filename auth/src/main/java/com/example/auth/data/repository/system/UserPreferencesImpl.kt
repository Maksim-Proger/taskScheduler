package com.example.auth.data.repository.system

import com.example.auth.domain.repository.system.SPRepository
import com.example.auth.domain.repository.system.UserPreferences
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class UserPreferencesImpl @Inject constructor(
    private val spRepository: SPRepository
) : UserPreferences {
    private val _registrationFlag = MutableStateFlow(spRepository.getRegistrationFlag())
    override val registrationFlag: StateFlow<Boolean> = _registrationFlag

    private val _userId = MutableStateFlow(spRepository.getUserId())
    override val userId: StateFlow<String?> = _userId

    private val _userName = MutableStateFlow(spRepository.getUserName())
    override val userName: StateFlow<String?> = _userName

    private val _userEmail = MutableStateFlow(spRepository.getUserEmail())
    override val userEmail: StateFlow<String?> = _userEmail

    override fun saveRegistrationFlag(flag: Boolean) {
        spRepository.saveRegistrationFlag(flag)
        _registrationFlag.value = flag
    }

    override fun saveUserId(id: String) {
        spRepository.saveUserId(id)
        _userId.value = id
    }

    override fun saveUserName(name: String) {
        spRepository.saveUserName(name)
        _userName.value = name
    }

    override fun saveUserEmail(email: String) {
        spRepository.saveUserEmail(email)
        _userEmail.value = email
    }
}
