package com.dood.kotlinservices.customerservice.customer.service

import com.dood.kotlinservices.customerservice.customer.model.Customer
import com.dood.kotlinservices.customerservice.customer.model.Customer.Telephone
import com.dood.kotlinservices.customerservice.customer.model.CustomerRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import reactor.core.publisher.Mono

@Service
class CustomerService {
    @Autowired
    lateinit var customerRepository: CustomerRepository //intellij prompted for lateinit
    //by default return type is Unit
    fun init(numberOfCustomers: Int) {
        for (i in 1..numberOfCustomers) {
            var customer = createCustomer(numberOfCustomers.toString())
            customerRepository.save(customer)
        }
    }

    fun saveCustomer(customer: Customer): Mono<Customer> {
        return customerRepository.save(customer)
    }
//    utility functioms
    fun createCustomer(customerNumber: String ) : Customer {
        //research how to not set id I know kotlin can do that with nullable or default values
         return Customer(id = null, name = customerNumber, telephone = createTelephone(customerNumber))
    }

    fun createTelephone(customerNumber: String) : Telephone {
        return Telephone(countryCode = customerNumber, telephoneNumber = customerNumber)
    }
}