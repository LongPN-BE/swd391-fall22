package com.groupswd391.fall22.OrderDetail;


import com.groupswd391.fall22.Order.Order;
import com.groupswd391.fall22.Order.OrderRepository;
import com.groupswd391.fall22.OrderDetail.DTO.OrderDetailRequest;
import com.groupswd391.fall22.OrderDetail.DTO.OrderDetailResponse;
import com.groupswd391.fall22.projectItem.entity.ProjectItem;
import com.groupswd391.fall22.projectItem.repository.ProjectItemRepository;
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
public class OrderDetailServiceImpl implements OrderDetailService {

    final
    OrderDetailRepository orderDetailRepository;
    final
    OrderRepository orderRepository;
    final
    ProjectItemRepository projectItemRepository;
    final
    ModelMapper modelMapper;

    public OrderDetailServiceImpl(OrderDetailRepository orderDetailRepository, OrderRepository orderRepository, ProjectItemRepository projectItemRepository, ModelMapper modelMapper) {
        this.orderDetailRepository = orderDetailRepository;
        this.orderRepository = orderRepository;
        this.projectItemRepository = projectItemRepository;
        this.modelMapper = modelMapper;
    }


    @Override
    public OrderDetailResponse createOrderDetail(OrderDetailRequest orderDetailRequest) {
        OrderDetail orderDetail = modelMapper.map(orderDetailRequest, OrderDetail.class);
        Order order = orderRepository.findById(orderDetailRequest.getOrderID()).orElseThrow(
                () -> new ResourceNotFoundException("Not found Order")
        );
        ProjectItem projectItem = projectItemRepository.findById(orderDetailRequest.getProjectItemID()).orElseThrow(
                () -> new ResourceNotFoundException("Not found Project Item")
        );
        orderDetail.setOrder(order);
        orderDetail.setProjectItem(projectItem);
        OrderDetail saveOrder = orderDetailRepository.save(orderDetail);
        return OrderDetailResponse.buildFromOrderDetail(saveOrder);
    }

    @Override
    public OrderDetailResponse updateOrderDetail(OrderDetailRequest orderDetailRequest, int id) {
        OrderDetail oldOrderDetail = orderDetailRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Not found Order Detail")
        );
        Order order = orderRepository.findById(orderDetailRequest.getOrderID()).orElseThrow(
                () -> new ResourceNotFoundException("Not found Order")
        );
        ProjectItem projectItem = projectItemRepository.findById(orderDetailRequest.getProjectItemID()).orElseThrow(
                () -> new ResourceNotFoundException("Not found Project Item")
        );
        oldOrderDetail.setOrder(order);
        oldOrderDetail.setProjectItem(projectItem);
        OrderDetail saveOrder = orderDetailRepository.save(oldOrderDetail);
        return OrderDetailResponse.buildFromOrderDetail(saveOrder);
    }

    @Override
    public boolean deleteOrderDetail(int id) {
        OrderDetail orderDetail = orderDetailRepository.findById(id).orElseThrow(
                () -> new NotFoundException("Not found Order Detail")
        );
        orderDetailRepository.deleteById(id);
        return true;
    }

    @Override
    public Map<String, Object> getOrderDetails(int page, int size) {
        List<OrderDetail> orderDetails = null;
        Pageable paging = PageRequest.of(page, size);
        Page<OrderDetail> pageTuts = null;
        pageTuts = orderDetailRepository.findAll(paging);
        orderDetails = pageTuts.getContent();

        Map<String, Object> response = new HashMap<>();
        response.put("orderDetails", orderDetails);
        response.put("currentPage", pageTuts.getNumber());
        response.put("totalItems", pageTuts.getTotalElements());
        response.put("totalPages", pageTuts.getTotalPages());
        return response;
    }
}
