package com.dood.kotlinservices.customerservice.customer.repository

import com.dood.kotlinservices.customerservice.customer.model.Customer
import org.springframework.data.mongodb.repository.MongoRepository

interface CustomerRepository : MongoRepository<Customer, String>