package com.example.taskscheduler.data.database.sharedpreferences

import android.content.Context

object SharedPreferences {
    private const val SYSTEM_PREFERENCES = "system_preferences"
    private const val REGISTRATION_FLAG = "registration_flag"
    private const val USER_ID = "user_id"

    fun saveRegistrationFlag(context: Context, registrationFlag: Boolean) {
        val sharedPreferences = context.getSharedPreferences(SYSTEM_PREFERENCES, Context.MODE_PRIVATE)
        sharedPreferences.edit().putBoolean(REGISTRATION_FLAG, registrationFlag).apply()
    }
    fun getRegistrationFlag(context: Context): Boolean {
        val sharedPreferences = context.getSharedPreferences(SYSTEM_PREFERENCES, Context.MODE_PRIVATE)
        return sharedPreferences.getBoolean(REGISTRATION_FLAG, false)
    }
    fun saveUserId(context: Context, userId: String) {
        val sharedPreferences = context.getSharedPreferences(SYSTEM_PREFERENCES, Context.MODE_PRIVATE)
        sharedPreferences.edit().putString(USER_ID, userId).apply()
    }
    fun getUserId(context: Context): String? {
        val sharedPreferences = context.getSharedPreferences(SYSTEM_PREFERENCES, Context.MODE_PRIVATE)
        return sharedPreferences.getString(USER_ID, null)
    }
    fun clearUserData(context: Context) {
        val sharedPreferences = context.getSharedPreferences(SYSTEM_PREFERENCES, Context.MODE_PRIVATE)
        sharedPreferences.edit()
            .remove(USER_ID)
            .remove(REGISTRATION_FLAG)
            .apply()
    }
}