package com.dood.kotlinservices.orderservice.repository

import org.springframework.core.annotation.Order
import org.springframework.data.mongodb.repository.MongoRepository

interface OrderRepository : MongoRepository<Order, String> 