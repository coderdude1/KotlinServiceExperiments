package com.dood.kotlinservices.compositeservice.service

import com.dood.kotlinservices.compositeservice.model.Customer

interface CustomerService {
    fun getCustomer(id: Int) : Customer?
    fun searchCustomers(nameFilter: String): List<Customer>
}