package com.example.taskscheduler.domain.usecase.firebase

import com.example.taskscheduler.domain.repository.firebase.AuthenticationRepository
import javax.inject.Inject

class LogoutUserUseCase @Inject constructor(
    private val authenticationRepository: AuthenticationRepository
) {
    suspend operator fun invoke() {
        authenticationRepository.logoutUser()
    }
}