package com.example.taskscheduler.domain.usecase.firebase

import com.example.taskscheduler.domain.repository.FireBaseRepository
import javax.inject.Inject

class RegisterUserUseCase @Inject constructor(
    private val fireBaseRepository: FireBaseRepository
) {
    suspend operator fun invoke(email: String, password: String, name: String) {
        fireBaseRepository.registerUser(email, password, name)
    }
}