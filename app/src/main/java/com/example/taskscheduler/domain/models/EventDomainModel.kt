package com.example.taskscheduler.domain.models

data class EventDomainModel(
    val id: String = "",
    val text: String = "",
    val description: String = "",
    val startEvent: String = "",
    val finishEvent: String = "",
    val timestamp: Long = 0
)
