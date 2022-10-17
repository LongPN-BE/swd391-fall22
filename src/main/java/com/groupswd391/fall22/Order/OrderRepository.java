package com.groupswd391.fall22.Order;

import com.groupswd391.fall22.Order.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Integer> {
}