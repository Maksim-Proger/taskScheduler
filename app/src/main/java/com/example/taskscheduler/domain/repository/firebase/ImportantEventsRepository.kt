package com.example.taskscheduler.domain.repository.firebase

interface ImportantEventsRepository {
    suspend fun addNewEvent(userId: String)
    suspend fun changeEvent(userId: String, eventId: String)
    suspend fun observerEvent(userId: String)
    suspend fun deleteEvent(userId: String, eventId: String)
}