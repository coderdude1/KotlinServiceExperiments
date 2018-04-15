package com.dood.kotlinservices.customerservice.customer.repository

import com.dood.kotlinservices.customerservice.customer.model.Customer
import org.springframework.data.mongodb.repository.ReactiveMongoRepository
import reactor.core.publisher.Mono


//@Repository
//interface CustomerRepository : ReactiveMongoRepository<Customer, String> {
//    fun findByName(name: String): Flux<Customer>
//}
//@Repository
interface CustomerRepository : ReactiveMongoRepository<Customer, String> {
    fun findByName(name: String): Mono<Customer>
}



