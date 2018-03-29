package com.dood.kotlinservices.compositeservice.model

data class Customer(var id: Int = 0, val name: String = "", val telephone: Telephone? = null) {
    //nested vs inner (requires inner keyword).  does not have access to Customer props
    //same as a static nested class in java
    data class Telephone(var countryCode: String = "", var telephoneNumber: String = "")
}

