package com.ecommerce.online.dto;

import com.ecommerce.online.entity.Category;
import lombok.Data;

@Data
public class ProductResponseDto extends ProductDto {
    private Category category;
    private Long id;
}
