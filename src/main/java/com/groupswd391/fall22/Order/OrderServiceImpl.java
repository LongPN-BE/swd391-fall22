package com.groupswd391.fall22.Order;


import com.groupswd391.fall22.Application.Application;
import com.groupswd391.fall22.Application.ApplicationRepository;
import com.groupswd391.fall22.Order.DTO.OrderRequest;
import com.groupswd391.fall22.Order.DTO.OrderResponse;
import com.groupswd391.fall22.exception.ResourceNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;
import org.webjars.NotFoundException;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class OrderServiceImpl implements OrderService {

    final
    OrderRepository orderRepository;
    final
    ApplicationRepository applicationRepository;
    final
    ModelMapper modelMapper;

    public OrderServiceImpl(OrderRepository orderRepository, ApplicationRepository applicationRepository, ModelMapper modelMapper) {
        this.orderRepository = orderRepository;
        this.applicationRepository = applicationRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public OrderResponse createOrder(OrderRequest orderRequest) {
        Order order = modelMapper.map(orderRequest, Order.class);
        Application application = applicationRepository.findById(orderRequest.getApplicationID()).orElseThrow(
                () -> new ResourceNotFoundException("Not found Application")
        );
        order.setApplication(application);
        order.setTime(orderRequest.getTime());
        order.setAmount(orderRequest.getAmount());
        Order saveOrder = orderRepository.save(order);
        return OrderResponse.buildFromOrder(saveOrder);
    }

    @Override
    public OrderResponse updateOrder(OrderRequest orderRequest, int id) {
        Order oldOrder = orderRepository.findById(id).orElseThrow(
                () -> new NotFoundException("Not found Order")
        );
        Application application = applicationRepository.findById(orderRequest.getApplicationID()).orElseThrow(
                () -> new ResourceNotFoundException("Not found Application")
        );
        modelMapper.map(orderRequest, oldOrder);
        oldOrder.setApplication(application);
        oldOrder.setTime(orderRequest.getTime());
        oldOrder.setAmount(orderRequest.getAmount());
        Order saveOrder = orderRepository.save(oldOrder);
        return OrderResponse.buildFromOrder(saveOrder);
    }

    @Override
    public boolean deleteOrder(int id) {
        Order order = orderRepository.findById(id).orElseThrow(
                () -> new NotFoundException("Not found Order")
        );
        orderRepository.deleteById(id);
        return true;
    }

    @Override
    public Map<String, Object> getOrders(int page, int size) {
        List<Order> orders = null;
        Pageable paging = PageRequest.of(page, size);
        Page<Order> pageTuts = null;
        pageTuts = orderRepository.findAll(paging);
        orders = pageTuts.getContent();

        Map<String, Object> response = new HashMap<>();
        response.put("orders", orders);
        response.put("currentPage", pageTuts.getNumber());
        response.put("totalItems", pageTuts.getTotalElements());
        response.put("totalPages", pageTuts.getTotalPages());
        return response;
    }
}
