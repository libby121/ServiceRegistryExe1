package com.example.customer_instance1.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestClient;

import java.util.Map;

@RestController
@RequestMapping("/api/customers")
class CustomersController {

    private final RestClient rest;

    // RestClient.Builder is @LoadBalanced (bean shown below)
    CustomersController(RestClient.Builder builder) {
        // base URL is the Eureka service ID
        this.rest = builder.baseUrl("http://orders").build();
    }

    @GetMapping(value = "/{id}/order", produces = MediaType.APPLICATION_JSON_VALUE)
    public Map<String, Object> getCustomerOrder(@PathVariable long id) {
        // Call the orders service via Eureka service name
        Map<?,?> order = rest.get()
                .uri("/api/orders/{id}", id)
                .retrieve()
                .body(Map.class);

        return Map.of(
                "customerId", id,
                "order", order
        );
    }
}
