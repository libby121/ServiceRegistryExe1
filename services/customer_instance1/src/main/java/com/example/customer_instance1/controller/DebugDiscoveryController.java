package com.example.customer_instance1.controller;

import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
class DebugDiscoveryController {
  private final DiscoveryClient dc;
  DebugDiscoveryController(DiscoveryClient dc){ this.dc = dc; }

  @GetMapping("/debug/instances")
  public Object instances() {
    return Map.of(
      "services", dc.getServices(),
      "ordersInstances", dc.getInstances("orders").stream()
        .map(si -> si.getHost()+":"+si.getPort())
        .toList()
    );
  }
}
