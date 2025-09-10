package com.example.auth.domain.usecase.system

import com.example.auth.domain.repository.system.SPRepository
import javax.inject.Inject

class SaveUserEmailUseCase @Inject constructor(
    private val repository: SPRepository
) {
    operator fun invoke(userEmail: String) {
        repository.saveUserEmail(userEmail)
    }
}