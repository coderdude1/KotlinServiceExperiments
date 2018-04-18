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

//    all the examples used this, might be older version of AbstractReactiveMongoClient?  I think this can
    //be used for a non-reactive repo if I want, so I might mix stuff and expose some of each (like making
//    a parallel call from composite to 2 non-composite to a non-webflux endpoint vs a flux endpoint
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