package com.dood.kotlinservices.orderservice.service

import com.dood.kotlinservices.orderservice.extensions.getRandomElement
import com.dood.kotlinservices.orderservice.extensions.random
import com.dood.kotlinservices.orderservice.model.LineItem
import com.dood.kotlinservices.orderservice.model.Order
import com.dood.kotlinservices.orderservice.repository.ReactiveOrderRepository
import mu.KLogging
import org.springframework.stereotype.Service

@Service
class OrderService(val reactiveOrderRepository: ReactiveOrderRepository, val orderRepository: ReactiveOrderRepository) {
    companion object : KLogging() //make it part of this class, companion makes it static

    val itemNames: List<String> = listOf("car", "beer", "lamp", "notebook", "snowmobile", "dog", "pencil", "Blorple",
            "NarklFrak", "stereo", "tree", "flower", "fire extinguisher", "more dogs")

    /**
     * This one is really just to validate the creation of orders with fake customerIds
     */
    fun createFakeCustomerOrders() {
        val customerIds = List(randomNumberOfCustomerIds()) { java.util.UUID.randomUUID().toString() }
        createCustomerOrders(customerIds)
    }

//    fun getCustomerOrders(customerid: String): List<Order> {
//        reactiveOrderRepository.
//    }

    /**
     * Use this one when called from the composite to use real customerIds that are created
     * after creating a bunch of customers
     */
    fun createCustomerOrders(customerIds: List<String>) {
//        logger.info { "creating ${customerIds.size} customer orders" }
        val orders: MutableList<Order> = mutableListOf()
        customerIds.forEach { customerId -> orders.add(createOrder(customerId)) }
        orderRepository.saveAll(orders) //could not get reactive one to work, even with block()
    }

    fun createOrder(customerId: String): Order {
        val lineItems = MutableList(randomNumberOfItems()) { index ->
            createLineItem(randomItemQuantity(), index.toString())
        }
        val order = Order(customerId = customerId, lineItems = lineItems)
        logger.info { "created and persisted order: $order" } //repo.save().block does not work, nor does just .save due to flux repo
        return order
    }

    fun createLineItem(quantity: Int, itemName: String): LineItem =
            LineItem(quantity, getItemName(), itemCost = getItemCost())

    //research naming conventions for lambdas
    fun randomItemQuantity(): Int = (1..20).random()

    fun randomNumberOfItems(): Int = (1..10).random()

    fun randomNumberOfCustomerIds(): Int = (1..1000).random()

    fun getItemName(): String = itemNames.getRandomElement() //note I have to import this since it is defined outside of this file

    fun getItemCost(): Double = (0.1..1000.0).random()
}