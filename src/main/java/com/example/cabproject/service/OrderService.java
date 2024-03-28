package com.example.cabproject.service;

import com.example.cabproject.dto.OrderRequestDto;
import com.example.cabproject.dto.OrderResponseDto;
import com.example.cabproject.entity.OrderEntity;
import com.example.cabproject.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;
    private  final ModelMapper mapper;


    public List<OrderResponseDto> getAllOrders () {
        List<OrderEntity> all = orderRepository.findAll();
        return  all.stream()
                .map(orderEntity -> mapper.map(orderEntity, OrderResponseDto.class))
                .collect(Collectors.toList());

    }


    public void createOrder (OrderEntity orderEntity) {
        OrderEntity map = mapper.map(orderEntity, OrderEntity.class);
        orderRepository.save(map);

    }

    public void deleteOrder (long id) {
        orderRepository.deleteById(id);
        ResponseEntity.ok("Order id deleted");
    }


    public OrderEntity update (Long id, OrderRequestDto orderRequestDto) {
        OrderEntity orderEntity = orderRepository.findById(id).orElseThrow();
        OrderEntity map = mapper.map(orderRequestDto, OrderEntity.class);
        orderEntity.setId(map.getId());
        orderEntity.setFrom(map.getFrom());
        orderEntity.setTo(map.getTo());

        OrderEntity save = orderRepository.save(orderEntity);
        return (save);
    }










}
