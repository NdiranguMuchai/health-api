package com.ndirangu.health.service;

import com.ndirangu.health.model.Order;
import com.ndirangu.health.model.Patient;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;
import java.util.UUID;

public interface OrderService {
    UUID create(Order order) ;
    Page<Order> list(Pageable pageable);
    Optional<Order> findOne(UUID id) throws Exception;
    UUID update(Order order) throws Exception;
}
