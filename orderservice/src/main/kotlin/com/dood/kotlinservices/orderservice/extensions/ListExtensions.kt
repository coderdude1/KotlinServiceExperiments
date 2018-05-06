package com.dood.kotlinservices.orderservice.extensions

import java.util.concurrent.ThreadLocalRandom


/*
  should I start creating a commons for kotlin snippets?
 */

/**
 * Extension function on any list that will return a random element from index 0
 * to the last index
 *
 * itemNames[((0..itemNames.size).random())] //look into list.shuffled
 *
 */
fun <T> List<T>.getRandomElement() = this[ThreadLocalRandom.current().nextInt(this.size)]
