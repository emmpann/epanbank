package com.efan.epan_bank.view

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.efan.epan_bank.R
import com.efan.epan_bank.controller.ControllerModule.loginController
import com.efan.epan_bank.model.ModelModule
import com.efan.epan_bank.model.observer.AccountObeserver

class LoginActivity : AppCompatActivity(), LoginView, AccountObeserver {

    private val model = ModelModule.dataAccessLayer
    private val controller = loginController()

    lateinit var button_login: Button
    lateinit var username: EditText
    lateinit var password: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        controller.bind(this)

        initComponents()
    }

    private fun initComponents() {
        button_login = findViewById(R.id.button_login)
        username = findViewById(R.id.username)
        password = findViewById(R.id.password)

        button_login.setOnClickListener {
            controller.onLoginButtonClicked()
        }
    }

    override fun onStart() {
        super.onStart()
        model.register(this)
    }

    override fun onStop() {
        super.onStop()
        model.unregister(this)
    }

    override fun getUsername() = username.text.toString()

    override fun getPassword() = password.text.toString()

    override fun accountLoggedIn() {
        val account = queryAccount()
         showMessage("Hello ${account.firstName} ${account.lastName}!")

        // move to home page and send data
        val intent = Intent(this, HomeActivity::class.java)
        intent.putExtra("username", account.firstName + " " + account.lastName)
        startActivity(intent)
        finish()
    }

    override fun accountUnknown() {
        showMessage("Inccorect username or password")
    }

    private fun showMessage(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

    private fun queryAccount() = model.getCurrentAccount()
}