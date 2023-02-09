package com.efan.epan_bank.model.domain

const val UNKNOWN = ""

data class Account(
    val firstName: String = UNKNOWN,
    val lastName: String = UNKNOWN,
    val email: String = UNKNOWN
)