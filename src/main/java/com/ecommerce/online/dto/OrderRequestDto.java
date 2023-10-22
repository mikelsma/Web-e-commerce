package com.ecommerce.online.dto;

import com.ecommerce.online.entity.Client;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;
@Data
public class OrderRequestDto {
    private Long id;
    @JsonProperty("client_id")
    private Long clientId;

    @JsonProperty("payment_status")
    private PaymentStatus paymentStatus;

    @JsonProperty("total_amount")
    private Double totalAmount;

    @JsonProperty("order_items")
    private List<OrderItemsRequestDto> orderItemsRequest;

}