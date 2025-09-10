package com.example.auth.domain.usecase.firebase

import com.example.auth.domain.repository.firebase.AuthenticationRepository
import javax.inject.Inject

class LogoutUserUseCase @Inject constructor(
    private val authenticationRepository: AuthenticationRepository
) {
    suspend operator fun invoke() {
        authenticationRepository.logoutUser()
    }
}