package com.efan.epan_bank.model.validator

import com.efan.epan_bank.model.domain.Credintal

interface Validator {
    fun validate(credintal: Credintal): Boolean
}