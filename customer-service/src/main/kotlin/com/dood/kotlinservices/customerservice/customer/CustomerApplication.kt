package com.dood.kotlinservices.customerservice.customer

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
//@EnableWebFluxSecurity
class CustomerApplication

fun main(args: Array<String>) {
    runApplication<CustomerApplication>(*args)
}
