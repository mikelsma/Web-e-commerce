package com.ecommerce.online.service;

import com.ecommerce.online.dto.OrderItemsResponseDto;
import com.ecommerce.online.dto.OrderRequestDto;
import com.ecommerce.online.dto.OrderResponseDto;
import com.ecommerce.online.entity.Client;
import com.ecommerce.online.entity.OrderItem;
import com.ecommerce.online.entity.Orders;
import com.ecommerce.online.entity.Product;
import com.ecommerce.online.repository.ClientRepository;
import com.ecommerce.online.repository.OrderItemRepository;
import com.ecommerce.online.repository.OrderRepository;
import com.ecommerce.online.repository.ProductRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private OrderItemRepository orderItemRepository;
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private ClientRepository clientRepository;
    private ModelMapper modelMapper = new ModelMapper();
    public OrderResponseDto createOrder(OrderRequestDto
                                                requestDto) {
        Client client = clientRepository
                .findById(requestDto.getClientId()).get();
        List<Long> ids = requestDto.getOrderItemsRequest()
                .stream()
                .map(orderItem -> orderItem.getProductId())
                .collect(Collectors.toList());

        List<Product> productsList =
                productRepository.findByIdIn(ids);

        Map<Long, Integer> mapsOfItem = new HashMap<>();
        requestDto.getOrderItemsRequest().stream().forEach(
                orderItemsRequestDto ->
                        mapsOfItem.put(orderItemsRequestDto.getProductId(),
                                orderItemsRequestDto.getQuantity()));

        Double total = 0D;
        Orders order = new Orders();
        for (Product product: productsList) {
            total+= product.getPrice() *
                    mapsOfItem.get(product.getId());
        }

        order.setTotalAmount(total);
        order.setClient(client);
        order.setPaymentStatus(requestDto.getPaymentStatus());
        Orders orderResult = orderRepository.save(order);
        OrderResponseDto orderResponseDto = modelMapper.map(orderResult,
                OrderResponseDto.class);
        List<OrderItemsResponseDto> orderItemsResponseDtos =
                new ArrayList<>();

        for (Product product: productsList) {
            OrderItem orderItem = new OrderItem();
            orderItem.setProduct(product);
            orderItem.setQuantity(mapsOfItem.get(product.getId()));
            orderItem.setOrders(orderResult);
            orderItem.setPrice(product.getPrice());
            orderItem.setSubTotal(orderItem.getQuantity() * orderItem.getPrice());
            OrderItem response = orderItemRepository.save(orderItem);
            orderItemsResponseDtos.add(modelMapper.map(response,
                    OrderItemsResponseDto.class));
        }
        orderResponseDto.setOrderItemsResponse(orderItemsResponseDtos);
        return orderResponseDto;
    }
}









