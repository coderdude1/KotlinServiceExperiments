package com.dood.kotlinservices.customerservice.customer.controller

import com.dood.kotlinservices.customerservice.customer.model.Customer
import com.dood.kotlinservices.customerservice.customer.service.CustomerService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

//TODO rewrite this using router
@RestController
@RequestMapping("/api")
class CompositeController {

    @Autowired
    lateinit var customerService: CustomerService

    @GetMapping(value = "/customer/{id}")
    //function body now, directly using ResponseEntity to set httpStatus per book
    fun getCustomer(@PathVariable id: String): Mono<Customer> {
        return customerService.getCustomer(id)
    }

    @GetMapping()
    fun getAllCustomers(): Flux<Customer> = customerService.getAllCustomers()


    @PostMapping(value = "/customer")
    fun createCustomer(@RequestParam customer: Customer): Mono<Customer> =
            customerService.saveCustomer(customer)

    @PostMapping(value = "/init/{numOfCustomers}")
    fun initCustomers(@PathVariable numOfCustomers: Int) =
            customerService.init(numOfCustomers)
}