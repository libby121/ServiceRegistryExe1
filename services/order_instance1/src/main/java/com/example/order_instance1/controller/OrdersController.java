package com.example.order_instance1.controller;

import org.example.dto.OrderDto;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.Instant;
import java.util.Map;

@RestController
@RequestMapping("/orders")
class OrdersController {

  @Value("${server.port}")
  private String instanceId;

  @GetMapping("/{id}")
   public OrderDto getOrder(@PathVariable("id") Long id) {
    return new OrderDto(id, 42L, "PAID", 3, 99.90);
  }

}
