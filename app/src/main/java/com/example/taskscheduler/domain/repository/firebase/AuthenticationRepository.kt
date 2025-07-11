package com.example.taskscheduler.domain.repository.firebase

import com.example.taskscheduler.domain.models.UserDomainModel

interface AuthenticationRepository {
    suspend fun registerUser(email: String, password: String, name: String)
    suspend fun loginUser(email: String, password: String): UserDomainModel
    suspend fun logoutUser()
}