package com.groupswd391.fall22.Order;


import com.groupswd391.fall22.Order.DTO.OrderRequest;
import com.groupswd391.fall22.Order.DTO.OrderResponse;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public interface OrderService {
    OrderResponse createOrder(OrderRequest orderRequest);

    OrderResponse updateOrder(OrderRequest orderRequest, int id);

    boolean deleteOrder(int id);

    Map<String, Object> getOrders(int page, int size);
}
