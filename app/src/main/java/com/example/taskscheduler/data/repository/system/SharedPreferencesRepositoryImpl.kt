package com.example.taskscheduler.data.repository.system

import android.content.Context
import com.example.taskscheduler.data.database.sharedpreferences.SharedPreferences
import com.example.taskscheduler.domain.repository.system.SystemSharedPreferencesRepository
import javax.inject.Inject

class SharedPreferencesRepositoryImpl @Inject constructor(
    private val context: Context
) : SystemSharedPreferencesRepository {

    override fun saveRegistrationFlag(registrationFlag: Boolean) {
        SharedPreferences.saveRegistrationFlag(context, registrationFlag)
    }

    override fun getRegistrationFlag(): Boolean {
        return SharedPreferences.getRegistrationFlag(context)
    }

    override fun saveUserId(userId: String) {
        SharedPreferences.saveUserId(context, userId)
    }

    override fun getUserId(): String? {
        return SharedPreferences.getUserId(context)
    }

    override fun clearUserData() {
        SharedPreferences.clearUserData(context)
    }

}