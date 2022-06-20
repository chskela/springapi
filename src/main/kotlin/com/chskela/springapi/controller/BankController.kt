package com.chskela.springapi.controller

import com.chskela.springapi.models.Bank
import com.chskela.springapi.service.BankService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/banks")
class BankController(private val service: BankService) {

    @GetMapping
    fun getBanks() : Collection<Bank> = service.getBanks()
}