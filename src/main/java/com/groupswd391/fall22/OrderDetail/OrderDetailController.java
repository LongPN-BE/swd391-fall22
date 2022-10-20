package com.groupswd391.fall22.OrderDetail;

import com.groupswd391.fall22.OrderDetail.DTO.OrderDetailRequest;
import com.groupswd391.fall22.OrderDetail.DTO.OrderDetailResponse;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Map;

@RestController
@RequestMapping("/api/orderDetails")
public class OrderDetailController {
    final
    OrderDetailService orderDetailService;

    public OrderDetailController(OrderDetailService orderDetailService) {
        this.orderDetailService = orderDetailService;
    }

    @GetMapping
    ResponseEntity<Map<String, Object>> getOrderDetails(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {
        try {
            return new ResponseEntity<>(orderDetailService.getOrderDetails(page, size), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Operation(
            summary = "Tạo 1 order detail mới ",
            description = "Tạo 1 order  detail mới "
    )
    @PostMapping()
    OrderDetailResponse addOrderDetail(@Valid @RequestBody OrderDetailRequest orderDetailRequest) {
        return orderDetailService.createOrderDetail(orderDetailRequest);
    }

    @DeleteMapping("/{id}")
    ResponseEntity<?> deleteOrderDetail(@PathVariable int id) {
        if (orderDetailService.deleteOrderDetail(id)) {
            return new ResponseEntity<>("DELETE SUCCESSFULLY", null, HttpStatus.OK);
        }
        return new ResponseEntity<>("DELETE SUCCESSFULLY", null, HttpStatus.BAD_REQUEST);
    }

    @Operation(
            summary = "Thay đổi thông tin order detail",
            description = "truyền id order detail muốn thay đổi"
    )
    @PutMapping("/{id}")
    OrderDetailResponse updateOrderDetail(@Valid @RequestBody OrderDetailRequest orderDetailRequest, @PathVariable int id) {
        return orderDetailService.updateOrderDetail(orderDetailRequest, id);
    }
}
