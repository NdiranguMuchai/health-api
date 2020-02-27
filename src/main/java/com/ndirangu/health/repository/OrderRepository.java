package com.ndirangu.health.repository;

import com.ndirangu.health.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface OrderRepository extends JpaRepository<Order, UUID> {
    Optional<Order>findById(UUID orderId);
}
