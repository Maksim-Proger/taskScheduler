package com.example.taskscheduler.domain.usecase.firebase

import com.example.taskscheduler.domain.repository.FireBaseRepository
import javax.inject.Inject

class LoginUserUseCase @Inject constructor(
    private val fireBaseRepository: FireBaseRepository
) {
    suspend operator fun invoke(email: String, password: String) {
        fireBaseRepository.loginUser(email, password)
    }
}