package com.ecommerce.online.repository;

import com.ecommerce.online.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    List<Product> findByProductNameContaining(String name);
    Optional<Product> findById(Long Id);
    List<Product> findByIdIn(List<Long> ids);
}

