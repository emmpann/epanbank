package com.efan.epan_bank.model

import com.efan.epan_bank.model.domain.Credintal
import com.efan.epan_bank.model.observer.AccountObeserver
import com.efan.epan_bank.model.observer.DomainObserver
import com.efan.epan_bank.model.validator.Validator

class DataAccessLayer (
    private val userValidator: Validator,
    private val accountRepository: AccountRepository
) {

    /**
     * business logic for accessing data
     */
    private val observers = mutableListOf<DomainObserver>()

    fun register(observer: DomainObserver) = observers.add(observer)

    fun unregister(observer: DomainObserver) = observers.remove(observer)

    // this method do validate account, if true notify that accountLoggedIn
    fun performLogin(username: String, password: String) {
        val credintal = Credintal(username, password)

        if (userValidator.validate(credintal)) {
            notify(AccountObeserver::accountLoggedIn)
        } else {
            notify(AccountObeserver::accountUnknown)
        }
    }

    private fun notify(action: (AccountObeserver) -> Unit) {
        observers.filterIsInstance<AccountObeserver>().onEach { action(it) }
    }

    fun getCurrentAccount() = accountRepository.account2
}