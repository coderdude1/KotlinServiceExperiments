package com.dood.kotlinservices.customerservice.customer.service

import com.dood.kotlinservices.customerservice.customer.model.Customer
import com.dood.kotlinservices.customerservice.customer.model.Customer.Telephone
import com.dood.kotlinservices.customerservice.customer.repository.ReactiveCustomerRepository
import org.springframework.stereotype.Service
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

@Service
class CustomerService(val reactiveCustomerRepository: ReactiveCustomerRepository) {
/*
Intellij warns of unassigned Mono/Flux instance and after reading a SO post to get the repository save to work
I think this might be important.  Research

I think this is related to using a ReactiveRepo that isn't getting done properly, ie not receiving a stream?  for generic
creates gonna move those to non-reactive variants like what I've done in OrderRepository
 */
    //by default return type is Unit
    fun init(numberOfCustomers: Int) {
        val customers: MutableList<Customer> = mutableListOf() //bet I can do this better with kotlin, maybe a stream
        for (i in 1..numberOfCustomers) {
            customers.add(createCustomer(i.toString()))
        }
    //blockfirst() vs blockLast?  this does get stuff to persist since I don't return the flux?
    //reearch if returning a flux can remove the block
        val saved = reactiveCustomerRepository.saveAll(customers).blockFirst()
    }

    fun getCustomer(id: String): Mono<Customer> = reactiveCustomerRepository.findById(id)

    fun getAllCustomers() : Flux<Customer> = reactiveCustomerRepository.findAll()

    fun saveCustomer(customer: Customer): Mono<Customer> = reactiveCustomerRepository.save(customer)

//    utility functioms
    fun createCustomer(customerNumber: String ) : Customer {
        //research how to not set id I know kotlin can do that with nullable or default values
         return Customer(id = null, name = customerNumber, telephone = createTelephone(customerNumber))
    }

    fun createTelephone(customerNumber: String) : Telephone {
        return Telephone(countryCode = customerNumber, telephoneNumber = customerNumber)
    }
}