package com.example.taskscheduler.di

import com.example.taskscheduler.data.repository.firebase.ImportantEventsRepositoryImpl
import com.example.taskscheduler.domain.repository.firebase.ImportantEventsRepository
import com.google.firebase.database.DatabaseReference
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    // region Firebase

    @Provides
    @Singleton
    fun provideImportantEventsRepository(
        databaseReference: DatabaseReference
    ): ImportantEventsRepository {
        return ImportantEventsRepositoryImpl(databaseReference)
    }

    // endregion

}