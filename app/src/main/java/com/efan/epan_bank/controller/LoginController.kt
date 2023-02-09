package com.efan.epan_bank.controller

import com.efan.epan_bank.model.DataAccessLayer
import com.efan.epan_bank.view.LoginView

class LoginController(private val model: DataAccessLayer) {
    /**
     * Login controller handle view binding and login button
     */

    private lateinit var view: LoginView

    fun bind(loginView: LoginView) { view = loginView }

    /*
    this method does login by using performLogin method
    model is DataAccessLayer, an object paramater
     */
    fun onLoginButtonClicked() {
        model.performLogin(view.getUsername(), view.getPassword())
    }
}