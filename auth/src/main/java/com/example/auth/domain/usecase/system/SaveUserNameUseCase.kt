package com.example.auth.domain.usecase.system

import com.example.auth.domain.repository.system.SPRepository
import javax.inject.Inject

class SaveUserNameUseCase @Inject constructor(
    private val repository: SPRepository
) {
    operator fun invoke(userName: String) {
        repository.saveUserName(userName)
    }
}