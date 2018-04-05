package com.dood.kotlinservices.customerservice.customer.controller

import com.dood.kotlinservices.customerservice.customer.model.Customer
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
class CompositeController {
    @GetMapping(value = "/customer/{id}")
    //function body now, directly using ResponseEntity to set httpStatus per book
    fun getCustomer(@PathVariable id: Int): ResponseEntity<Customer> {
        return ResponseEntity(Customer(id, "Customer Entity $id"), HttpStatus.OK)
    }

    @PostMapping(value = "/customer")
    fun createCustomer(@RequestParam customer: Customer) {

    }
}