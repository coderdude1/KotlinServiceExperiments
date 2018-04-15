package com.dood.kotlinservices.customerservice.customer.service

import com.dood.kotlinservices.customerservice.customer.model.Customer
import com.dood.kotlinservices.customerservice.customer.model.Customer.Telephone
import com.dood.kotlinservices.customerservice.customer.repository.CustomerRepository
import org.springframework.stereotype.Service
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

@Service
class CustomerService(val customerRepository: CustomerRepository) {

    //by default return type is Unit
    fun init(numberOfCustomers: Int) {
        val customers: MutableList<Customer> = mutableListOf()
        for (i in 1..numberOfCustomers) {
            customers.add(createCustomer(i.toString()))
        }
        try {
            val saved = customerRepository.saveAll(customers)
            println(saved)
        } catch (e: Exception) {
            println(e)
        }
    }

    fun getCustomer(id: String): Mono<Customer> = customerRepository.findById(id)

    fun getAllCustomers() : Flux<Customer> = customerRepository.findAll()

    fun saveCustomer(customer: Customer): Mono<Customer> = customerRepository.save(customer)

//    utility functioms
    fun createCustomer(customerNumber: String ) : Customer {
        //research how to not set id I know kotlin can do that with nullable or default values
         return Customer(id = null, name = customerNumber, telephone = createTelephone(customerNumber))
    }

    fun createTelephone(customerNumber: String) : Telephone {
        return Telephone(countryCode = customerNumber, telephoneNumber = customerNumber)
    }
}