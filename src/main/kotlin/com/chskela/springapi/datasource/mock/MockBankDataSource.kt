package com.chskela.springapi.datasource.mock

import com.chskela.springapi.datasource.BankDataSource
import com.chskela.springapi.models.Bank
import org.springframework.stereotype.Repository

@Repository("mock")
class MockBankDataSource : BankDataSource {
    private val banks = listOf(
        Bank("1234", 10.0, 4),
        Bank("34535", 3.14, 3),
        Bank("1345345354", 3.14, 17),
    )

    override fun retrieveBanks(): Collection<Bank> = banks

    override fun retrieveBank(accountNumber: String): Bank =
        banks.firstOrNull { bank -> bank.accountNumber == accountNumber }
            ?: throw NoSuchElementException("Could not find a bank with account number $accountNumber")
}