package com.example.taskscheduler.domain.repository.system

interface SPRepository {
    fun saveRegistrationFlag(registrationFlag: Boolean)
    fun getRegistrationFlag(): Boolean
    fun saveUserId(userId: String)
    fun getUserId(): String?
    fun saveUserName(userName: String)
    fun getUserName(): String?
    fun saveUserEmail(userEmail: String)
    fun getUserEmail(): String?
    fun clearUserData()
}