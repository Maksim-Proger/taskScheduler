package com.example.auth.domain.usecase.system

import com.example.auth.domain.repository.system.SPRepository
import javax.inject.Inject

class GetRegistrationFlagUseCase @Inject constructor(
    private val repository: SPRepository
) {
    operator fun invoke(): Boolean {
        return repository.getRegistrationFlag()
    }
}