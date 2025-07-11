package com.example.taskscheduler.domain.usecase.firebase

import com.example.taskscheduler.domain.models.UserDomainModel
import com.example.taskscheduler.domain.repository.firebase.AuthenticationRepository
import javax.inject.Inject

class LoginUserUseCase @Inject constructor(
    private val authenticationRepository: AuthenticationRepository
) {
    suspend operator fun invoke(email: String, password: String): UserDomainModel {
        return authenticationRepository.loginUser(email, password)
    }
}