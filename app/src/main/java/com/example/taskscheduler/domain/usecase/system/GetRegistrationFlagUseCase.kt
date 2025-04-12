package com.example.taskscheduler.domain.usecase.system

import com.example.taskscheduler.domain.repository.system.SystemSharedPreferencesRepository
import javax.inject.Inject

class GetRegistrationFlagUseCase @Inject constructor(
    private val repository: SystemSharedPreferencesRepository
) {
    operator fun invoke(): Boolean {
        return repository.getRegistrationFlag()
    }
}