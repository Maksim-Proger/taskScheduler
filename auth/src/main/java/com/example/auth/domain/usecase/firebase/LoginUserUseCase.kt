package com.example.auth.domain.usecase.firebase

import com.example.auth.domain.model.UserDomainModel
import com.example.auth.domain.repository.firebase.AuthenticationRepository
import javax.inject.Inject

class LoginUserUseCase @Inject constructor(
    private val authenticationRepository: AuthenticationRepository
) {
    suspend operator fun invoke(email: String, password: String): UserDomainModel {
        return authenticationRepository.loginUser(email, password)
    }
}