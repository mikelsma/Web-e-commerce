package com.ecommerce.online.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class OrderItemsRequestDto {
    @JsonProperty("product_id")
    private Long productId;
    private Integer quantity;
}
