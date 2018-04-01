package com.dood.kotlinservices.compositeservice.model

//telephone is nullable, which when the controler is called is valid (telephone=null
data class Customer(var id: Int = 0, val name: String = "", val telephone: Telephone? = null) {
    //nested vs inner (requires inner keyword).  does not have access to Customer props
    //same as a static nested class in java and jackson is not set ablut nullable props
    data class Telephone(var countryCode: String = "", var telephoneNumber: String = "")
}

