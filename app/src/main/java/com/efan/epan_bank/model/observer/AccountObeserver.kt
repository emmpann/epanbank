package com.efan.epan_bank.model.observer

interface AccountObeserver : DomainObserver {

    fun accountLoggedIn()

    fun accountUnknown()
}