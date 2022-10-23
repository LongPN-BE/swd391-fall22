package com.groupswd391.fall22.Transaction;

import com.groupswd391.fall22.Transaction.DTO.TransactionRequest;
import com.groupswd391.fall22.Transaction.DTO.TransactionResponse;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Map;

@RestController
@RequestMapping("/api/transactions")
public class TransactionController {
    final
    TransactionService transactionService;

    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @GetMapping
    ResponseEntity<Map<String, Object>> getTransactions(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {
        try {
            return new ResponseEntity<>(transactionService.getTransactions(page, size), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Operation(
            summary = "Tạo 1 Transaction mới ",
            description = "Tạo 1 Transaction mới "
    )
    @PostMapping()
    TransactionResponse addTransaction(@Valid @RequestBody TransactionRequest transactionRequest) {
        return transactionService.createTransaction(transactionRequest);
    }

    @DeleteMapping("/{id}")
    ResponseEntity<?> deleteTransaction(@PathVariable int id) {
        if (transactionService.deleteTransaction(id)) {
            return new ResponseEntity<>("DELETE SUCCESSFULLY", null, HttpStatus.OK);
        }
        return new ResponseEntity<>("DELETE SUCCESSFULLY", null, HttpStatus.BAD_REQUEST);
    }

    @Operation(
            summary = "Thay đổi thông tin transaction",
            description = "truyền id transaction muốn thay đổi"
    )
    @PutMapping("/{id}")
    TransactionResponse updateTransaction(@Valid @RequestBody TransactionRequest transactionRequest, @PathVariable int id) {
        return transactionService.updateTransaction(transactionRequest, id);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findWalletByID(@PathVariable int id) {
        return transactionService.getTransactionById(id);
    }

    @GetMapping("/order/{orderId}")
    public ResponseEntity<?> findTransactionByOrder(@PathVariable int orderId) {
        return transactionService.getTransactionById(orderId);
    }
    @GetMapping("/wallet/{walletId}")
    public ResponseEntity<?> findTransactionByWallet(@PathVariable int walletId) {
        return transactionService.getTransactionById(walletId);
    }
}
