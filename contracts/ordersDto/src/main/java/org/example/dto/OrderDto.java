package org.example.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public record OrderDto(Long id, Long customerId, String status, Integer itemsCount, Double total) {}
