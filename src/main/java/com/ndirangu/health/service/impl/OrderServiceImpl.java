package com.ndirangu.health.service.impl;

import com.ndirangu.health.model.Order;
import com.ndirangu.health.repository.OrderRepository;
import com.ndirangu.health.service.OrderService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;
import java.util.UUID;

public class OrderServiceImpl implements OrderService {
    private OrderRepository orderRepository;

    public OrderServiceImpl(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public UUID create(Order order) {
        return orderRepository.save(order).getId();
    }

    @Override
    public Page<Order> list(Pageable pageable) {
        return orderRepository.findAll(pageable);
    }

    @Override
    public Optional<Order> findOne(UUID id) throws Exception {
        orderRepository.findById(id).orElseThrow(()-> new Exception("order with id "+id+" not found"));
        return orderRepository.findById(id);
    }

    @Override
    public UUID update(Order order) throws Exception {
        orderRepository.findById(order.getId()).orElseThrow(()-> new Exception("order with id "+order.getId()+" not found"));
        order.setId(order.getId());
        return orderRepository.save(order).getId();
    }
}
