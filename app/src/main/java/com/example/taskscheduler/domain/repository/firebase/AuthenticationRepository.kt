package com.example.taskscheduler.domain.repository.firebase

import com.example.taskscheduler.domain.models.UserData

interface AuthenticationRepository {
    suspend fun registerUser(email: String, password: String, name: String)
    suspend fun loginUser(email: String, password: String): UserData
    suspend fun logoutUser()
}