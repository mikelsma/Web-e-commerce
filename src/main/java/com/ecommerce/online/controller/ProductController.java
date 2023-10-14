package com.ecommerce.online.controller;

import com.ecommerce.online.dto.ProductDto;
import com.ecommerce.online.entity.Product;
import com.ecommerce.online.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private ProductService productService;

    @PostMapping("/save")
    public ResponseEntity<ProductDto> create(@RequestBody ProductDto productDto) {
        return new ResponseEntity<>(productService.save(productDto), HttpStatusCode.valueOf(200));
    }
    @GetMapping("/all")
    public List<Product> getAllProducts() {
        return productService.getAllProductEntity();
    }
    @PatchMapping("/{id}")
    public ResponseEntity<ProductDto> updateProduct(@RequestBody ProductDto productDto,
                                                    @PathVariable Long id) {
        try{
            ProductDto response = productService
                    .updateProduct(id, productDto);
           return new ResponseEntity<>(response,
                   HttpStatusCode.valueOf(200));
        }catch (Exception e) {
            return new ResponseEntity<>(new ProductDto(),
                    HttpStatusCode.valueOf(500));
        }
    }

    @DeleteMapping("/delete/{productId}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Long productId){
        productService.deleteById(productId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
