package com.example.taskscheduler.domain.usecase.firebase

import com.example.taskscheduler.domain.repository.FireBaseRepository
import javax.inject.Inject

class LogoutUserUseCase @Inject constructor(
    private val fireBaseRepository: FireBaseRepository
) {
    suspend operator fun invoke() {
        fireBaseRepository.logoutUser()
    }
}