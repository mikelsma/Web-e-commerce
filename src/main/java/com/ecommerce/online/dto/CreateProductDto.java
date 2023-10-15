package com.ecommerce.online.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class CreateProductDto extends ProductDto {
    @JsonProperty("category_id")
    private Long categoryId;
}
