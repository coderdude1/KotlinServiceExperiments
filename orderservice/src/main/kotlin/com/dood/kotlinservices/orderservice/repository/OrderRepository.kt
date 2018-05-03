package com.dood.kotlinservices.orderservice.repository

import org.springframework.core.annotation.Order
import org.springframework.data.mongodb.repository.ReactiveMongoRepository

//@Repository //do I need this?
interface OrderRepository : ReactiveMongoRepository<Order, String>