package com.groupswd391.fall22.Order;

import com.groupswd391.fall22.Order.DTO.OrderRequest;
import com.groupswd391.fall22.Order.DTO.OrderResponse;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Map;

@RestController
@RequestMapping("/api/orders")
public class OrderController {
    final
    OrderService orderService;


    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping
    ResponseEntity<Map<String, Object>> getOrders(
            @RequestParam(required = false) String name,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {
        try {
            return new ResponseEntity<>(orderService.getOrders(page, size), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Operation(
            summary = "Tạo 1 order mới ",
            description = "Tạo 1 order mới "
    )
    @PostMapping()
    OrderResponse addMajor(@Valid @RequestBody OrderRequest orderRequest) {
        return orderService.createOrder(orderRequest);
    }

    @DeleteMapping("/{id}")
    ResponseEntity<?> deleteOrder(@PathVariable int id) {
        if (orderService.deleteOrder(id)) {
            return new ResponseEntity<>("DELETE SUCCESSFULLY", null, HttpStatus.OK);
        }
        return new ResponseEntity<>("DELETE SUCCESSFULLY", null, HttpStatus.BAD_REQUEST);
    }

    @Operation(
            summary = "Thay đổi thông tin order",
            description = "truyền id order muốn thay đổi"
    )
    @PutMapping("/{id}")
    OrderResponse updateOrder(@Valid @RequestBody OrderRequest orderRequest, @PathVariable int id) {
        return orderService.updateOrder(orderRequest, id);
    }
}
