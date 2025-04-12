package com.example.taskscheduler.domain.repository.system

interface SystemSharedPreferencesRepository {
    fun saveRegistrationFlag(registrationFlag: Boolean)
    fun getRegistrationFlag(): Boolean
    fun saveUserId(userId: String)
    fun getUserId(): String?
    fun clearUserData()
}