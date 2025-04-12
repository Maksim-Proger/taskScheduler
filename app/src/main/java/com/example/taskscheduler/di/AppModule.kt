package com.example.taskscheduler.di

import android.content.Context
import com.example.taskscheduler.data.repository.firebase.AuthenticationRepositoryImpl
import com.example.taskscheduler.data.repository.system.SharedPreferencesRepositoryImpl
import com.example.taskscheduler.domain.repository.firebase.AuthenticationRepository
import com.example.taskscheduler.domain.repository.system.SystemSharedPreferencesRepository
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
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
    fun provideSystemSharedPreferencesRepository(@ApplicationContext context: Context): SystemSharedPreferencesRepository {
        return SharedPreferencesRepositoryImpl(context)
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

    // endregion

}