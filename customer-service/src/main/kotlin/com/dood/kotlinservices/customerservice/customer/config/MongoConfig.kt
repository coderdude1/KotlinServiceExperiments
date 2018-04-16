package com.dood.kotlinservices.customerservice.customer.config

import com.dood.kotlinservices.customerservice.customer.repository.CustomerRepository
import com.mongodb.reactivestreams.client.MongoClient
import com.mongodb.reactivestreams.client.MongoClients
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.data.mongodb.core.ReactiveMongoTemplate
import org.springframework.data.mongodb.config.AbstractReactiveMongoConfiguration
import org.springframework.data.mongodb.repository.config.EnableReactiveMongoRepositories


@Configuration
@EnableReactiveMongoRepositories(basePackages=["com.dood.kotlinservices.customerservice.customer.repository"])
class MongoConfig : AbstractReactiveMongoConfiguration() {
    @Bean
    override fun reactiveMongoClient(): MongoClient {
        return MongoClients.create()
    }

//    all the examples used this, might be older version of AbstractReactiveMongoClient?
    @Bean
    fun mongoClient(): MongoClient {
        return MongoClients.create()
    }

    //this was not enough (exception about db name not set), needed the yml file to set the db.  whatup?
    override fun getDatabaseName(): String {
        return "customers"
    }

    @Bean
    override fun reactiveMongoTemplate(): ReactiveMongoTemplate {
        return ReactiveMongoTemplate(reactiveMongoClient(), databaseName)
    }
}