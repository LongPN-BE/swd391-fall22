//package com.groupswd391.fall22.Transaction;
//
//import com.groupswd391.fall22.Transaction.Transaction;
//import com.groupswd391.fall22.Transaction.TransactionRepository;
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
//public class TransactionController {
//    @Autowired
//    TransactionRepository transactionRepository;
//
//    @RequestMapping(value = "/transactions/", method = RequestMethod.GET)
//    public ResponseEntity<List<Transaction>> listAllTransactions(){
//        List<Transaction> listTransactions = transactionRepository.findAll();
//        if(listTransactions.isEmpty()) {
//            return new ResponseEntity(HttpStatus.NO_CONTENT);
//        }
//        return new ResponseEntity<List<Transaction>>(listTransactions, HttpStatus.OK);
//    }
//}
