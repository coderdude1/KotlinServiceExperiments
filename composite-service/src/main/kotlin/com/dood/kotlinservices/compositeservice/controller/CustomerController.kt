package com.dood.kotlinservices.compositeservice.controller

import com.dood.kotlinservices.compositeservice.model.Customer
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController

@RestController
class CustomerController {
    @GetMapping(value = "/customer/{id}")
    //expresion body
    fun getCustomer(@PathVariable id: Int) = Customer(id, "customer $id")
}