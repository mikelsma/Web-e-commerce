package com.ecommerce.online.service;

import com.ecommerce.online.dto.CreateProductDto;
import com.ecommerce.online.dto.ProductDto;
import com.ecommerce.online.dto.ProductResponseDto;
import com.ecommerce.online.entity.Category;
import com.ecommerce.online.entity.Product;
import com.ecommerce.online.repository.CategoryRepository;
import com.ecommerce.online.repository.ProductRepository;
import jakarta.persistence.EntityNotFoundException;
import org.hibernate.action.internal.EntityActionVetoException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {


    ModelMapper modelMapper = new ModelMapper();
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private CategoryRepository categoryRepository;

    public ProductResponseDto save(CreateProductDto productDto) {
        Product product =  modelMapper.map(productDto, Product.class);
        Category existingCategory = categoryRepository.findById(productDto.getCategoryId()).orElseThrow(()->
                new EntityNotFoundException("!category"));

        product.setCategory(existingCategory);
        return modelMapper.map(productRepository.save(product), ProductResponseDto.class);
    }
    public ProductDto updateProduct(Long id,
                                    ProductDto productDto) {
        Product existingProduct = productRepository.findById(id).orElseThrow(()->
                new EntityNotFoundException("!product"));
        Product request = modelMapper.map(productDto,
                Product.class);
        modelMapper.map(request, existingProduct);

        Product response = productRepository.save(existingProduct);
        return modelMapper.map(response, ProductDto.class);
    }
    public List<Product> getAllProductEntity(){
        return productRepository.findAll();
}
    public Product getProductEntityById(Long id) {
        Product existingProduct = productRepository.findById(id).orElseThrow(()->
                new EntityNotFoundException("!product not found"));

        return existingProduct;
}
    public void deleteById(Long id) {
    productRepository.deleteById(id);
}
}
