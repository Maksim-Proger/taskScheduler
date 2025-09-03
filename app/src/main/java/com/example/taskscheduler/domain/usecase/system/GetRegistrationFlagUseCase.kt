package com.example.taskscheduler.domain.usecase.system

import com.example.taskscheduler.domain.repository.system.SPRepository
import javax.inject.Inject

class GetRegistrationFlagUseCase @Inject constructor(
    private val repository: SPRepository
) {
    operator fun invoke(): Boolean {
        return repository.getRegistrationFlag()
    }
}