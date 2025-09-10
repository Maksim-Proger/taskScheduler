package com.example.auth.domain.repository.firebase

import com.example.auth.domain.model.UserDomainModel

interface AuthenticationRepository {
    suspend fun registerUser(email: String, password: String, name: String)
    suspend fun loginUser(email: String, password: String): UserDomainModel
    suspend fun logoutUser()
}