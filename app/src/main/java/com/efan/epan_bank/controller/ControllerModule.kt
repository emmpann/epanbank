package com.efan.epan_bank.controller

import com.efan.epan_bank.model.ModelModule

object ControllerModule {

    // making new LoginController object
    fun loginController() = LoginController(ModelModule.dataAccessLayer)

}