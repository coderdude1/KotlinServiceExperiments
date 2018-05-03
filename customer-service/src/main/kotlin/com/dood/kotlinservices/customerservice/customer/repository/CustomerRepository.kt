package com.dood.kotlinservices.customerservice.customer.repository

import com.dood.kotlinservices.customerservice.customer.model.Customer
import org.springframework.data.mongodb.repository.ReactiveMongoRepository
import reactor.core.publisher.Mono

//@Repository //this seems to work without this.  why?
interface CustomerRepository : ReactiveMongoRepository<Customer, String> {
    fun findByName(name: String): Mono<Customer>
}


/*
TODO insert some records into a customer collection and see if getAll works

 */
