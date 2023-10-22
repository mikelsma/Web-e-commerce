package com.ecommerce.online.dto;

import com.ecommerce.online.entity.Product;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.time.LocalDate;

@Data
public class OrderItemsResponseDto {

    private Long id;

    private Product product;

    private Double price;

    private Integer quantity;

    @JsonProperty("sub_total")
    private Double subTotal;

    @JsonProperty("created_at")
    private LocalDate createdAt;

    @JsonProperty("updated_at")
    private LocalDate updatedAt;
}