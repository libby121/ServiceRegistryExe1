package com.example.order_instance1.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.Instant;
import java.util.Map;

@RestController
@RequestMapping("/api/orders")
class OrdersController {

  @Value("${server.port}")
  private String instanceId;

  @GetMapping("/{id}")
  public Map<String,Object> getOrder(@PathVariable long id) {
    return Map.of(
      "orderId", id,
      "servedBy", instanceId,
      "timestamp", Instant.now().toString()
    );
  }
}
