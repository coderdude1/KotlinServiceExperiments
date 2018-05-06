package com.dood.kotlinservices.orderservice.controller

import com.dood.kotlinservices.orderservice.service.OrderService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

//TODO rewrite this using router
@RestController
@RequestMapping("/api")
class OrderController {
    @Autowired
    lateinit var orderService: OrderService

//    @GetMapping(value = "/customer/{id}")
//    //function body now, directly using ResponseEntity to set httpStatus per book
//    fun getCustomer(@PathVariable id: String): Flux<Order> {
////        return orderService.getCustomerOrders(id)
//        return null;
//    }

    @GetMapping(value = "/init")
    fun init() =
            orderService.createFakeCustomerOrders()
}