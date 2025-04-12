package com.example.taskscheduler.domain.usecase.system

import com.example.taskscheduler.domain.repository.system.SystemSharedPreferencesRepository
import javax.inject.Inject

class ClearUserDataUseCase @Inject constructor(
    private val repository: SystemSharedPreferencesRepository
) {
    operator fun invoke() {
        repository.clearUserData()
    }
}