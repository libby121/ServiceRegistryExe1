package com.example.customer_instance1.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClient;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.Map;

    @RestController
    @RequestMapping("/api/customers")
    class CustomersController {

        private final WebClient webClient;

        CustomersController(WebClient.Builder builder) {
            // @LoadBalanced builder → service-name URLs are resolved via Eureka
            this.webClient = builder.build();
        }

        @GetMapping(value = "/{id}/order", produces = MediaType.APPLICATION_JSON_VALUE)
        public Mono<Map<String, Object>> getCustomerOrder(@PathVariable long id) {
            Mono<Map> orderMono = webClient.get()
                    .uri("http://orders/api/orders/{id}", id) // service NAME, not host
                    .retrieve()
                    .bodyToMono(Map.class);

            return orderMono.map(order -> Map.of(
                    "customerId", id,
                    "order", order
            ));
        }
    }
