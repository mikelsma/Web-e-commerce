package com.ecommerce.online.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Column;
import lombok.Data;

@Data
public class ProductDto {
    @JsonProperty("product_name")
    private String productName;
    private String description;
    private Long price;
    private Integer quantity;
    @JsonProperty("photo_name")
    private String photoName;
}
