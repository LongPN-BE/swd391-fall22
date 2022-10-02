//package com.groupswd391.fall22.Order;
//
//import com.groupswd391.fall22.Order.Order;
//import com.groupswd391.fall22.Order.OrderRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RestController;
//
//import java.util.List;
//
//@RestController
//@RequestMapping("/api")
//public class OrderController {
//    @Autowired
//    OrderRepository orderRepository;
//
//    @RequestMapping(value = "/orders/", method = RequestMethod.GET)
//    public ResponseEntity<List<Order>> listAllOrders(){
//        List<Order> listOrders = orderRepository.findAll();
//        if(listOrders.isEmpty()) {
//            return new ResponseEntity(HttpStatus.NO_CONTENT);
//        }
//        return new ResponseEntity<List<Order>>(listOrders, HttpStatus.OK);
//    }
//}
