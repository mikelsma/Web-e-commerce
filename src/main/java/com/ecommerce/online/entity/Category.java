package com.ecommerce.online.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity(name= "category")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name= "category_name")
    private String categoryName;
}
