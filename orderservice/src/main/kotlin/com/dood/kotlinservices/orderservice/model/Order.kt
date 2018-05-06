package com.dood.kotlinservices.orderservice.model

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

/*
TODO.
    verify not null id works (will have to generate the id in the repo/service)
    kotlin collections (mutable vs immmutable?  addItem requirex it, but that means the default getLineItems returns
        a mutable list
    make a mutable model object vs an immutable entity?  Probably this keeps the entity immutable

 */
@Document
data class Order(@Id var id: String? = null, val customerId: String, val lineItems: List<LineItem>) {
    //not sure the below will work unless I make it a mutable collection.  figure it out later
//    fun addItem(item: LineItem) = lineItems.add(item)
//    fun removeItem()
}

data class LineItem(val quantity: Int, val itemName: String, val itemCost: Number)
