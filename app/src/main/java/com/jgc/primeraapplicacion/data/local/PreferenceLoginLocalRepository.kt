package com.jgc.primeraapplicacion.data.local

import android.content.SharedPreferences
import android.util.Log
import com.jgc.primeraapplicacion.model.User

class PreferenceLoginLocalRepository(private val sharedPreferences: SharedPreferences) :
    LoginLocalRepository {
    override suspend fun setLoggedUser(user: User) {
        val editor = sharedPreferences.edit()
        editor.putString("username", user.username)
        editor.putString("password", user.password)
        editor.apply()
    }

    override suspend fun getLoggedUser(): User? {
        val username = sharedPreferences.getString("username", null)
        val password = sharedPreferences.getString("password", null)
        return if (username != null && password != null) {
            User(username, password)
        } else {
            null
        }

    }

    override suspend fun deleteLoggedUser() {
        sharedPreferences.edit().clear().apply()
        Log.e(1.toString(),"------------------------ERROR")
    }


}