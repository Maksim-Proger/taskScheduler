package com.example.taskscheduler.data.database.sharedpreferences

import android.content.Context

object SharedPreferences {
    private const val SYSTEM_PREFERENCES = "system_preferences"
    private const val REGISTRATION_FLAG = "registration_flag"
    private const val USER_ID = "user_id"
    private const val USER_NAME = "user_name"
    private const val USER_EMAIL = "user_email"

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
    fun saveUserName(context: Context, userName: String) {
        val sharedPreferences = context.getSharedPreferences(SYSTEM_PREFERENCES, Context.MODE_PRIVATE)
        sharedPreferences.edit().putString(USER_NAME, userName).apply()
    }
    fun getUserName(context: Context): String? {
        val sharedPreferences = context.getSharedPreferences(SYSTEM_PREFERENCES, Context.MODE_PRIVATE)
        return sharedPreferences.getString(USER_NAME, null)
    }
    fun saveUserEmail(context: Context, userEmail: String) {
        val sharedPreferences = context.getSharedPreferences(SYSTEM_PREFERENCES, Context.MODE_PRIVATE)
        sharedPreferences.edit().putString(USER_EMAIL, userEmail).apply()
    }
    fun getUserEmail(context: Context): String? {
        val sharedPreferences = context.getSharedPreferences(SYSTEM_PREFERENCES, Context.MODE_PRIVATE)
        return sharedPreferences.getString(USER_EMAIL, null)
    }
    fun clearUserData(context: Context) {
        val sharedPreferences = context.getSharedPreferences(SYSTEM_PREFERENCES, Context.MODE_PRIVATE)
        sharedPreferences.edit()
            .remove(USER_ID)
            .remove(USER_NAME)
            .remove(USER_EMAIL)
            .remove(REGISTRATION_FLAG)
            .apply()
    }
}