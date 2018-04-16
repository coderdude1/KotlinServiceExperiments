#Customer Service
Part of the kotlin spring5 reactive stuff.  This is a backend service that will
be consumed by the composite service.  The idea is this service provides
reactive endpoints thru to reactive mongo.  Composite will call this and anther service to compose
data, etc.

For now this will be a pure kotlin service.  eventually will write a java variant and figure out
how to mix java/kotlin stuff with the new spring5 stuff

#TODOs
1. controllers using the new router thingy
2.  kradle
3.  eventually create 100k plus records to measure streaming
#Stuff to figure out

#Questions
1.  Is it good practice to put the repository in the same file as the data entity
2.  Probably worth adding a DTO that is used to hide the entity?
3.  package structures using kotlin?  multiple stuff per file?   group by functions vs model/service/etc

#Sources
I used the hands on microservices with kotlin: build reactive and cloud naitve mircoservices with kotlin using spring 5 and springboot 2.0

Some helpful links
https://dzone.com/articles/spring-boot-reactive-tutorial
https://medium.com/@rhwolniewicz/building-a-rest-service-with-kotlin-spring-boot-mongodb-and-junit-14d10faa594b

Swagger currently has issues with WebFlux https://github.com/springfox/springfox/issues/1773
support soon

#Notes
1.  Swagger 2.9 will add webflux support

# Something to research and understand better
stuff was not persisting until I added a block on the save call in the service call to the repository.
https://stackoverflow.com/questions/47238418/spring-webflux-mongodb-document-is-not-saved-into-database