package com.ecommerce.online.dto;

import com.ecommerce.online.entity.Client;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
public class OrderResponseDto {
    private Long id;

    private Client client;

    @JsonProperty("payment_status")
    private PaymentStatus paymentStatus;

    @JsonProperty("total_amount")
    private Double totalAmount;

    @JsonProperty("order_items")
    private List<OrderItemsResponseDto> orderItemsResponse;

    @JsonProperty("created_at")
    private LocalDate createdAt;

    @JsonProperty("updated_at")
    private LocalDate updatedAt;
}
