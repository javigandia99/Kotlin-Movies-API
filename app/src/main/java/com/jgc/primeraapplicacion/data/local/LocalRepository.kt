package com.jgc.primeraapplicacion.data.local

import com.jgc.primeraapplicacion.model.User

interface LocalRepository{
    suspend fun setLoggedUser(user: User)
    suspend fun getLoggedUser() : User?
    suspend fun deleteLoggedUser()

}
