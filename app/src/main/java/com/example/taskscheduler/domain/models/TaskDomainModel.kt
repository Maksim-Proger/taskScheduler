package com.example.taskscheduler.domain.models

data class TaskDomainModel(
    val id: String = "",
    val text: String = "",
    val description: String = "",
    val timestamp: Long = 0
)
