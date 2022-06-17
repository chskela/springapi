package com.chskela.springapi.datasource.mock

import com.chskela.springapi.datasource.BankDataSource
import com.chskela.springapi.models.Bank

class MockBankDataSource : BankDataSource {
    private val banks = listOf(
        Bank("1234", 10.0, 4),
        Bank("1234", 3.14, 3),
        Bank("1234", 3.14, 17),
    )

    override fun retrieveBanks(): Collection<Bank> = banks
}