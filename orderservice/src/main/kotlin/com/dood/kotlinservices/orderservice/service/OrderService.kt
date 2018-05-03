package com.dood.kotlinservices.orderservice.service

import com.dood.kotlinservices.orderservice.model.LineItem
import com.dood.kotlinservices.orderservice.model.Order
import com.dood.kotlinservices.orderservice.repository.OrderRepository
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service
import java.util.concurrent.ThreadLocalRandom

@Service
class OrderService(val orderRepository: OrderRepository) {
    val logger: Logger = LoggerFactory.getLogger(OrderService::class.java)
    val itemNames: List<String> = listOf("car", "beer", "lamp", "notebook", "snowmobile", "dog", "pencil")

    //easy way to generate randoms Ints wwith a range
    fun ClosedRange<Int>.random() =
            ThreadLocalRandom.current().nextInt(endInclusive - start) + start

    fun ClosedRange<Double>.random() =
            ThreadLocalRandom.current().nextDouble(endInclusive - start) + start

    fun init(numberOfOrdersPerCustomer: Number, customerIds: List<String>) {

    }

    fun createOrder(customerId: String) {
        val lineItems: MutableList<LineItem> = mutableListOf() //bet I can do this better with kotlin, maybe a stream
        val numOfLineItems: Int = (1..10).random()
        for (i in 1..numOfLineItems) {
            lineItems.add(createLineItem((1..3).random(), i.toString()))
        }
        val order = Order(customerId = customerId, lineItems = lineItems)
    }

    fun createLineItem(quantity: Int, itemName: String): LineItem {
        return LineItem(quantity, itemName, itemCost = (0.1..1000.0).random())
    }

    fun getItemName(): String {
        return itemNames[((0..itemNames.size).random())] //look into list.shuffled
    }
}