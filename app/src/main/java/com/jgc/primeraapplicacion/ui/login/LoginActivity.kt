package com.jgc.primeraapplicacion.ui.login

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.jgc.primeraapplicacion.R
import com.jgc.primeraapplicacion.data.local.PreferencesLocalRepository
import com.jgc.primeraapplicacion.data.remote.RetrofitFactory
import com.jgc.primeraapplicacion.data.remote.RetrofitRemoteRepository
import com.jgc.primeraapplicacion.ui.main.MainActivity

class LoginActivity : AppCompatActivity(), LoginView {
    private lateinit var usernameTxt: EditText
    private lateinit var passwordTxt: EditText
    private lateinit var loginButton: Button
    private lateinit var clearButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        usernameTxt = findViewById(R.id.username_edit_txt)
        passwordTxt = findViewById(R.id.password_edit_txt)
        loginButton = findViewById(R.id.login_button)
        clearButton = findViewById(R.id.clear_button)

        val localRepository = PreferencesLocalRepository(
            getSharedPreferences(
                "login_preference",
                Context.MODE_PRIVATE
            )
        )
        val remoteRepository = RetrofitRemoteRepository(RetrofitFactory.getMovieApi())
        val presenter = LoginPresenter(this, localRepository, remoteRepository)

        loginButton.setOnClickListener {
            presenter.onLoginClicked(usernameTxt.text.toString(), passwordTxt.text.toString())
        }

        clearButton.setOnClickListener {
            presenter.onClearClicked()
        }
        presenter.init()
    }

    override fun showLoginSuccessful() {
        Toast.makeText(this, "Login successful", Toast.LENGTH_SHORT).show()
        enterInApp()
    }

    override fun showLoginError() {
        Toast.makeText(this, "Login error", Toast.LENGTH_SHORT).show()
        clearFields()
    }

    override fun showFieldRequiredError(emptyList: List<String>) {
        Toast.makeText(
            this,
            "The fields ${emptyList.joinToString()} are required",
            Toast.LENGTH_SHORT
        ).show()
    }

    override fun clearFields() {
        usernameTxt.text.clear()
        passwordTxt.text.clear()
    }

    override fun enterInApp() {
        startActivity(Intent(this, MainActivity::class.java))
        finish()
    }

}
