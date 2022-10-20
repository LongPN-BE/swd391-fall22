package com.groupswd391.fall22.OrderDetail;

import com.groupswd391.fall22.OrderDetail.DTO.OrderDetailRequest;
import com.groupswd391.fall22.OrderDetail.DTO.OrderDetailResponse;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public interface OrderDetailService {
    OrderDetailResponse createOrderDetail(OrderDetailRequest orderDetailRequest);

    OrderDetailResponse updateOrderDetail(OrderDetailRequest orderDetailRequest, int id);

    boolean deleteOrderDetail(int id);

    Map<String, Object> getOrderDetails(int page, int size);

}
