package com.efan.epan_bank.model

import com.efan.epan_bank.model.validator.LoginValidator

object ModelModule {

    val dataAccessLayer: DataAccessLayer by lazy { dataAccessLayer() }

    /*
    this method make an object of DataAccessLayer which pass 2 parameter:
    those paramater make a new object in java it looks like (new LoginValidator(), new AccountRepository())
     */
    private fun dataAccessLayer() = DataAccessLayer(LoginValidator(), AccountRepository())
}