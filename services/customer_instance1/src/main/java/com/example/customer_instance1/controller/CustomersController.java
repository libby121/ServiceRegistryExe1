package com.example.customer_instance1.controller;

import org.example.dto.OrderDto;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

 @RestController
 @RequestMapping("/customers")
public class CustomersController {

     private static final Logger log = LoggerFactory.getLogger(CustomersController.class);

     private final WebClient.Builder webClientBuilder;

     public CustomersController(WebClient.Builder webClientBuilder) {

         this.webClientBuilder = webClientBuilder;
     }
     @GetMapping("/orders/{id}")
     public Mono<OrderDto> getOrder(@PathVariable("id") long id) {
         return webClientBuilder
                 .build()
                 // IMPORTANT: use the SERVICE ID from Eureka, not host:port
                 .get().uri("http://orders/orders/{id}", id)
                 .retrieve()
                 .bodyToMono(OrderDto.class)
                         .doOnSuccess(o -> log.info("✅ Order {} reçu depuis orders", id))
                 .doOnError(e -> log.error("❌ Échec appel orders pour id={}", id, e));
     }
}
