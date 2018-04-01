package com.dood.kotlinservices.compositeservice.controller

import com.dood.kotlinservices.compositeservice.model.Customer
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController

@RestController
class CustomerController {
    @GetMapping(value = "/customer/{id}")
    //function body now, directly using ResponseEntity to set httpStatus per book
    fun getCustomer(@PathVariable id: Int): ResponseEntity<Customer> {
        return ResponseEntity(Customer(id, "Customer Entity $id"), HttpStatus.OK)
    }
}