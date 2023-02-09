package com.efan.epan_bank.model

import com.efan.epan_bank.model.domain.Account

class AccountRepository {

    internal val account: Account = Account("efan", "fitriyan", "efitr22@gmail.com")
    internal val account2: Account = Account("yolen", "fitri", "efitr22@gmail.com")
}