package com.jgc.primeraapplicacion.ui.profile

import com.jgc.primeraapplicacion.data.local.LoginLocalRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class ProfilePresenter(val view: ProfileFragment, private val loginLocalRepository: LoginLocalRepository) {
    fun logoutClicked() {
        CoroutineScope(Dispatchers.IO).launch {
            loginLocalRepository.deleteLoggedUser()
            withContext(Dispatchers.Main) {
                view.goToLogin()
            }
        }
    }
}

interface ProfileView {
    fun goToLogin()
}