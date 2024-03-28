package com.example.cabproject.controller;

import com.example.cabproject.dto.OrderRequestDto;
import com.example.cabproject.dto.OrderResponseDto;
import com.example.cabproject.entity.OrderEntity;
import com.example.cabproject.service.OrderService;
import lombok.Data;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("order")
@Data
public class OrderController {

    private final OrderService orderService;



    @GetMapping("/get-all")
    public List<OrderResponseDto> getAllOrder () {
        return orderService.getAllOrders();
    }

    @PostMapping("/create")
    public ResponseEntity<String> createOrder(@RequestBody OrderEntity order) {
        orderService.createOrder(order);
        return ResponseEntity.ok("Order is created!");
    }

    @PutMapping("/post")
    public OrderEntity updateOrder (@PathVariable Long id, OrderRequestDto orderRequestDto) {
        return orderService.update(id, orderRequestDto);
    }

    @DeleteMapping("/delete{id}")
    public ResponseEntity<String> deleteOrderById (@PathVariable long id) {
        orderService.deleteOrder(id);
        return ResponseEntity.ok("Order is deleted!");
    }
}

