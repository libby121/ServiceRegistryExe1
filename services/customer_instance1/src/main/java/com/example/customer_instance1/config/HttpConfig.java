package com.example.customer_instance1.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.reactive.ReactorClientHttpConnector;
import org.springframework.web.client.RestClient;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Configuration
class HttpConfig {

  /**
   * @LoadBalanced enables service name resolution (e.g., http://orders)
   * through Spring Cloud LoadBalancer + Eureka.
   * Spring Boot/Cloud will auto-apply any RestClientCustomizer beans.
   */
  @Bean
  @LoadBalanced
  RestClient.Builder restClientBuilder() {
    return RestClient.builder();
  }
}
