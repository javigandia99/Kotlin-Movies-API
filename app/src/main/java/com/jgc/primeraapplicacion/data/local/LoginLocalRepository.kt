package com.jgc.primeraapplicacion.data.local

import com.jgc.primeraapplicacion.model.User

interface LoginLocalRepository{
    suspend fun setLoggedUser(user: User)
    suspend fun getLoggedUser() : User?
    suspend fun deleteLoggedUser()

}
