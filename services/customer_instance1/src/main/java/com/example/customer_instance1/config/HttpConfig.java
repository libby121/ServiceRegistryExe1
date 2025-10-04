// src/main/java/.../HttpConfig.java
package com.example.customer_instance1.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.reactive.ReactorClientHttpConnector;
import org.springframework.web.reactive.function.client.*;
import reactor.core.publisher.Mono;
import reactor.netty.http.client.HttpClient;

import java.time.Duration;

@Configuration
public class HttpConfig {

   @Bean
  @LoadBalanced
  public WebClient.Builder loadBalancedWebClientBuilder() {
      return WebClient.builder();
   }
}
