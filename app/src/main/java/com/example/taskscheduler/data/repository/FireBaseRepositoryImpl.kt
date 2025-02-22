package com.example.taskscheduler.data.repository

import com.example.taskscheduler.domain.repository.FireBaseRepository
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import javax.inject.Inject

class FireBaseRepositoryImpl @Inject constructor(
    private val databaseReference: DatabaseReference,
    private val firebaseAuth: FirebaseAuth
) : FireBaseRepository {

    // Регистрация нового пользователя
    override suspend fun registerUser(email: String, password: String) {
        firebaseAuth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    val user = firebaseAuth.currentUser
                } else {
                    // TODO: Добавить Exception
                }
            }
    }

    // Вход в аккаунт
    override suspend fun loginUser(email: String, password: String) {
        firebaseAuth.signInWithEmailAndPassword(email, password)
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    val user = firebaseAuth.currentUser
                } else {
                    // TODO: Добавить Exception
                }
            }
    }

    // Выход из аккаунта
    override suspend fun logoutUser() {
        firebaseAuth.signOut()
    }

}