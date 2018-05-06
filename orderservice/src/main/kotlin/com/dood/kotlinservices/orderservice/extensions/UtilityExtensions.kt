package com.dood.kotlinservices.orderservice.extensions

import java.util.concurrent.ThreadLocalRandom

//easy way to generate randoms Ints wwith a range
fun ClosedRange<Int>.random() =
        ThreadLocalRandom.current().nextInt(endInclusive - start) + start

fun ClosedRange<Double>.random() =
        ThreadLocalRandom.current().nextDouble(endInclusive - start) + start