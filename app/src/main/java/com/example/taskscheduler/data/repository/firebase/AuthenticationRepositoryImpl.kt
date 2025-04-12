package com.example.taskscheduler.data.repository.firebase

import com.example.taskscheduler.domain.models.UserData
import com.example.taskscheduler.domain.repository.firebase.AuthenticationRepository
import com.example.taskscheduler.utils.NODE_LIST_USERS
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException
import com.google.firebase.auth.FirebaseAuthInvalidUserException
import com.google.firebase.database.DatabaseReference
import kotlinx.coroutines.tasks.await
import javax.inject.Inject

class AuthenticationRepositoryImpl @Inject constructor(
    private val databaseReference: DatabaseReference,
    private val firebaseAuth: FirebaseAuth
) : AuthenticationRepository {

    // Сохраняем данные пользователя в базу
    private suspend fun saveUserData(userId: String, name: String, email: String) {
        val user = hashMapOf(
            "name" to name,
            "email" to email
        )
        databaseReference.child(NODE_LIST_USERS).child(userId).setValue(user).await()
    }

    // Регистрация нового пользователя
    override suspend fun registerUser(email: String, password: String, name: String) {
        try {
            val authResult = firebaseAuth.createUserWithEmailAndPassword(email, password).await()
            val user = authResult.user
            if (user != null) {
                saveUserData(user.uid, name, email)
            } else {
                throw Exception("User is null")
            }
        } catch (e: Exception) {
            throw Exception("Registration failed: ${e.message}")
        }
    }

    // Вход в аккаунт
    override suspend fun loginUser(email: String, password: String): UserData {
        try {
            val authResult = firebaseAuth.signInWithEmailAndPassword(email, password).await()
            val user = authResult.user ?: throw Exception("User is null")

            // Получение данных из Realtime Database
            val snapshot = databaseReference.child(NODE_LIST_USERS).child(user.uid).get().await()
            val name = snapshot.child("name").value as? String ?: "Unknown"
            val emailFromDb = snapshot.child("email").value as? String ?: user.email.orEmpty()

            return UserData(user.uid, name, emailFromDb)
        } catch (e: Exception) {
            val errorMessage = when (e) {
                is FirebaseAuthInvalidUserException -> "User not found"
                is FirebaseAuthInvalidCredentialsException -> "Invalid email or password"
                else -> "Login failed: ${e.message}"
            }
            throw Exception(errorMessage)
        }
    }

    // Выход из аккаунта
    override suspend fun logoutUser() {
        try {
            firebaseAuth.signOut()
        } catch (e: Exception) {
            throw Exception("Logout failed: ${e.message}")
        }
    }

}