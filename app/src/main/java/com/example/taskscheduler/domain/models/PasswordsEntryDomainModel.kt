package com.example.taskscheduler.domain.models

data class PasswordsEntryDomainModel(
    val id: String = "",
    val email: String = "",
    val password: String = "",
    val description: String = "",
    val timestamp: Long = 0
)
