package com.ndirangu.health.repository;

import com.ndirangu.health.model.Order;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface OrderRepository extends JpaRepository<Order, UUID> {
    Optional<Order>findById(UUID orderId);
    Page<Order>findByPatientId(UUID patientId, Pageable pageable);
    Optional<Order> findByIdAndAndPatientId(UUID orderId, UUID patientId);

}
