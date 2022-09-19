package com.groupswd391.fall22.repository;

import com.groupswd391.fall22.entity.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderDetailRepository extends JpaRepository<OrderDetail, String> {
}