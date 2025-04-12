package com.example.taskscheduler.domain.usecase.firebase

import com.example.taskscheduler.domain.repository.firebase.AuthenticationRepository
import javax.inject.Inject

class RegisterUserUseCase @Inject constructor(
    private val authenticationRepository: AuthenticationRepository
) {
    suspend operator fun invoke(email: String, password: String, name: String) {
        authenticationRepository.registerUser(email, password, name)
    }
}