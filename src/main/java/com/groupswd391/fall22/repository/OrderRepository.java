package com.groupswd391.fall22.repository;

import com.groupswd391.fall22.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, String> {
}