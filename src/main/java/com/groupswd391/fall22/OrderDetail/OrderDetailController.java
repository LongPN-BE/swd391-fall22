//package com.groupswd391.fall22.OrderDetail;
//
//import com.groupswd391.fall22.OrderDetail.OrderDetail;
//import com.groupswd391.fall22.OrderDetail.OrderDetailRepository;
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
//public class OrderDetailController {
//    @Autowired
//    OrderDetailRepository orderDetailRepository;
//
//    @RequestMapping(value = "/order-details/", method = RequestMethod.GET)
//    public ResponseEntity<List<OrderDetail>> listAllOrderDetails(){
//        List<OrderDetail> listOrderDetails = orderDetailRepository.findAll();
//        if(listOrderDetails.isEmpty()) {
//            return new ResponseEntity(HttpStatus.NO_CONTENT);
//        }
//        return new ResponseEntity<List<OrderDetail>>(listOrderDetails, HttpStatus.OK);
//    }
//}
