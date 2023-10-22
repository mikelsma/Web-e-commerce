package com.ecommerce.online.controller;

import com.ecommerce.online.dto.OrderRequestDto;
import com.ecommerce.online.dto.OrderResponseDto;
import com.ecommerce.online.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/order")
public class OrderController {
    @Autowired
    private OrderService orderService;
    @PostMapping
    public ResponseEntity<OrderResponseDto> createOrder(@RequestBody OrderRequestDto orderRequestDto) {
        OrderResponseDto response = orderService.createOrder(orderRequestDto);
        return new ResponseEntity<>(response, HttpStatusCode.valueOf(201));

    }

}
