package com.example.taskscheduler.di

import android.content.Context
import com.example.taskscheduler.data.repository.firebase.AuthenticationRepositoryImpl
import com.example.taskscheduler.data.repository.firebase.ImportantEventsRepositoryImpl
import com.example.taskscheduler.data.repository.system.SPRepositoryImpl
import com.example.taskscheduler.domain.repository.firebase.AuthenticationRepository
import com.example.taskscheduler.domain.repository.firebase.ImportantEventsRepository
import com.example.taskscheduler.domain.repository.system.SPRepository
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.auth
import com.google.firebase.Firebase
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    // region SharedPreferences

    @Provides
    @Singleton
    fun provideSPRepository(@ApplicationContext context: Context): SPRepository {
        return SPRepositoryImpl(context)
    }

    // endregion

    // region Firebase

    @Provides
    @Singleton
    fun provideFirebaseDatabase(): FirebaseDatabase {
        return FirebaseDatabase.getInstance()
    }

    @Provides
    @Singleton
    fun provideDatabaseReference(firebaseDatabase: FirebaseDatabase): DatabaseReference {
        return firebaseDatabase.reference
    }

    @Provides
    @Singleton
    fun provideFirebaseAuth(): FirebaseAuth {
        return Firebase.auth
    }

    @Provides
    @Singleton
    fun provideAuthenticationRepository(
        databaseReference: DatabaseReference,
        firebaseAuth: FirebaseAuth
    ): AuthenticationRepository {
        return AuthenticationRepositoryImpl(databaseReference, firebaseAuth)
    }

    @Provides
    @Singleton
    fun provideImportantEventsRepository(
        databaseReference: DatabaseReference
    ) : ImportantEventsRepository {
        return ImportantEventsRepositoryImpl(databaseReference)
    }

    // endregion

}