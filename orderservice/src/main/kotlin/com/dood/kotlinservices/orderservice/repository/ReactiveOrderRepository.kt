package com.dood.kotlinservices.orderservice.repository

import com.dood.kotlinservices.orderservice.model.Order
import org.springframework.data.mongodb.repository.ReactiveMongoRepository
import org.springframework.stereotype.Repository

@Repository
interface ReactiveOrderRepository : ReactiveMongoRepository<Order, String>