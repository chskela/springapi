package com.chskela.springapi.datasource

import com.chskela.springapi.models.Bank

interface BankDataSource {

    fun retrieveBanks(): Collection<Bank>
}