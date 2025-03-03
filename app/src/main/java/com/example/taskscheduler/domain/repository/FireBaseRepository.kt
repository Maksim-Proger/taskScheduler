package com.example.taskscheduler.domain.repository

interface FireBaseRepository {
    suspend fun registerUser(email: String, password: String, name: String)
    suspend fun loginUser(email: String, password: String)
    suspend fun logoutUser()
}