package com.example.taskscheduler.data.repository.system

import android.content.Context
import com.example.taskscheduler.data.database.sharedpreferences.SharedPreferences
import com.example.taskscheduler.domain.repository.system.SPRepository
import javax.inject.Inject

class SPRepositoryImpl @Inject constructor(
    private val context: Context
) : SPRepository {

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
    override fun saveUserName(userName: String) {
        SharedPreferences.saveUserName(context, userName)
    }
    override fun getUserName(): String? {
        return SharedPreferences.getUserName(context)
    }
    override fun saveUserEmail(userEmail: String) {
        SharedPreferences.saveUserEmail(context, userEmail)
    }
    override fun getUserEmail(): String? {
        return SharedPreferences.getUserEmail(context)
    }
    override fun clearUserData() {
        SharedPreferences.clearUserData(context)
    }

}