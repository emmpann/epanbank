package com.efan.epan_bank.model.validator

import com.efan.epan_bank.model.domain.Credintal

class LoginValidator : Validator {

    private val userCredintal = Credintal("epan", "epan123")
    private val userCredintal2 = Credintal("yolen", "yoleng")

    override fun validate(credintal: Credintal): Boolean {
        return credintal == userCredintal2
    }
}