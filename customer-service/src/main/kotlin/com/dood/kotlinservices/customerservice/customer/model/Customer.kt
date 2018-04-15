package com.dood.kotlinservices.customerservice.customer.model

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document


/**
 * This pattern (repo and entity in the same file was actually used in the lombok java example
 * I will follow this for now until I better understand kotlin patterns
 *
 * experiment with nullable and minimize it
 *
 * class vs data class?
 */
@Document(collection="customers")
data class Customer(@Id var id: String?, val name: String = "", val telephone: Telephone? = null) {
    //nested vs inner (requires inner keyword).  does not have access to Customer props
    //same as a static nested class in java and jackson is not set ablut nullable props
    data class Telephone(var countryCode: String = "", var telephoneNumber: String = "")
}

//I might extract this into its own file.
//also ReactiveMongoRepo vs ReactiveCrudRepository vs AbstractReactiveMongo
//I did not have luck getting this to work yet, gonna extract it out to a class instead
//@Repository
//interface CustomerRepository : ReactiveMongoRepository<Customer, String> {
//    fun findByName(name: String): Flux<Customer>
//}