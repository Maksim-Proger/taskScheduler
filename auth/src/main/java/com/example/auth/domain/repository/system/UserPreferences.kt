package com.example.auth.domain.repository.system

import kotlinx.coroutines.flow.StateFlow

interface UserPreferences {
    val registrationFlag: StateFlow<Boolean>
    val userId: StateFlow<String?>
    val userName: StateFlow<String?>
    val userEmail: StateFlow<String?>

    fun saveRegistrationFlag(flag: Boolean)
    fun saveUserId(id: String)
    fun saveUserName(name: String)
    fun saveUserEmail(email: String)
}