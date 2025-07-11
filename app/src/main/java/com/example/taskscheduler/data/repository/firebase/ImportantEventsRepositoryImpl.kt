package com.example.taskscheduler.data.repository.firebase

import com.example.taskscheduler.domain.repository.firebase.ImportantEventsRepository
import com.google.firebase.database.DatabaseReference
import javax.inject.Inject

class ImportantEventsRepositoryImpl @Inject constructor(
    private val databaseReference: DatabaseReference
) : ImportantEventsRepository {
    override suspend fun addNewEvent(userId: String) {
        TODO("Not yet implemented")
    }

    override suspend fun changeEvent(userId: String, eventId: String) {
        TODO("Not yet implemented")
    }

    override suspend fun observerEvent(userId: String) {
        TODO("Not yet implemented")
    }

    override suspend fun deleteEvent(userId: String, eventId: String) {
        TODO("Not yet implemented")
    }

}