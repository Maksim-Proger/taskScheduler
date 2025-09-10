package com.example.auth.di

import android.content.Context
import com.example.auth.data.repository.firebase.AuthenticationRepositoryImpl
import com.example.auth.data.repository.system.SPRepositoryImpl
import com.example.auth.data.repository.system.UserPreferencesImpl
import com.example.auth.domain.repository.firebase.AuthenticationRepository
import com.example.auth.domain.repository.system.SPRepository
import com.example.auth.domain.repository.system.UserPreferences
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AuthModule {

    // region SharedPreferences

    @Provides
    @Singleton
    fun provideSPRepository(@ApplicationContext context: Context): SPRepository {
        return SPRepositoryImpl(context)
    }

    // endregion

    // region UserPreferences

    @Provides
    @Singleton
    fun provideUserPreferences(spRepository: SPRepository): UserPreferences {
        return UserPreferencesImpl(spRepository)
    }

    // endregion

    // region AuthenticationRepository

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