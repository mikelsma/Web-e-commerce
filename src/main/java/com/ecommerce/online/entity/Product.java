package com.ecommerce.online.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity(name= "product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name= "product_name")
    private String productName;
    @Column(name= "description")
    private String description;
    @Column(name= "price")
    private Long price;
    @Column(name= "quantity")
    private Integer quantity;
    @Column(name= "photoName")
    private String photoName;
    @ManyToOne()
    @JoinColumn(name = "category_id")
    private Category category;

}
