#Overview
Experiments with Kotlin, springboot 2, and reactive microservices

Currently the goal is to create 3 microservices, one composite, two backing services.  Simple controllers will expose rest API's.  Some things I'd like to play with are reactive via WebFlux, reactive mongo, parallel calls (ie composite makes a parallel call to the two backing services and assembles the results, streaimng to the external client)

Experiments with kotlin modules, file organization, functional vs objects, and other things to gain experience with kotlin

#Some Things To Figure Out
1. using SLF4j  https://www.reddit.com/r/Kotlin/comments/8gbiul/slf4j_loggers_in_3_ways/
2. 