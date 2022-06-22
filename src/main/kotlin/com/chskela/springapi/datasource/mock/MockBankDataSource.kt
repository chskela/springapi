package com.chskela.springapi.datasource.mock

import com.chskela.springapi.datasource.BankDataSource
import com.chskela.springapi.models.Bank
import org.springframework.stereotype.Repository

@Repository("mock")
class MockBankDataSource : BankDataSource {
    private val banks = mutableListOf(
        Bank("1234", 10.0, 4),
        Bank("34535", 3.14, 3),
        Bank("1345345354", 3.14, 17),
    )

    override fun retrieveBanks(): Collection<Bank> = banks

    override fun retrieveBank(accountNumber: String): Bank =
        banks.firstOrNull { bank -> bank.accountNumber == accountNumber }
            ?: throw NoSuchElementException("Could not find a bank with account number $accountNumber")

    override fun createBank(bank: Bank): Bank {
        if (banks.any { it.accountNumber == bank.accountNumber }) {
            throw IllegalArgumentException("Bank with account number ${bank.accountNumber} already exist")
        }
        banks.add(bank)
        return bank
    }

    override fun updateBank(bank: Bank): Bank {
        val index = banks.indexOfFirst { it.accountNumber == bank.accountNumber }
        if (index == -1) {
            throw NoSuchElementException("Bank with account number ${bank.accountNumber} not exist")
        }

        banks[index] = bank
        return bank
    }
}