package com.example.taskscheduler.domain.usecase.system

import com.example.taskscheduler.domain.repository.system.SystemSharedPreferencesRepository
import javax.inject.Inject

class SaveUserNameUseCase @Inject constructor(
    private val repository: SystemSharedPreferencesRepository
) {
    operator fun invoke(userName: String) {
        repository.saveUserName(userName)
    }
}