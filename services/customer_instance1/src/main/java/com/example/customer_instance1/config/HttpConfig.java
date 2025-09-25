package com.example.customer_instance1.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.reactive.ReactorClientHttpConnector;
import org.springframework.web.client.RestClient;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.netty.http.client.HttpClient;

@Configuration
class HttpConfig {
  private static final Logger log = LoggerFactory.getLogger(HttpConfig.class);

  @Bean
  @LoadBalanced
  WebClient.Builder lbWebClientBuilder() {
    HttpClient httpClient = HttpClient.create().wiretap(true); // reactor-netty logs
    return WebClient.builder().clientConnector(new ReactorClientHttpConnector(httpClient));
  }
}
