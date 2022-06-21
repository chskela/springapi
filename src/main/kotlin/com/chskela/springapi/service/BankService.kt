package com.chskela.springapi.service

import com.chskela.springapi.datasource.BankDataSource
import com.chskela.springapi.models.Bank
import org.springframework.stereotype.Service

@Service
class BankService(private val dataSource: BankDataSource) {

    fun getBanks(): Collection<Bank> = dataSource.retrieveBanks()

    fun getBank(accountNumber: String): Bank = dataSource.retrieveBank(accountNumber)

    fun addBank(bank: Bank): Bank  = dataSource.createBank(bank)
}