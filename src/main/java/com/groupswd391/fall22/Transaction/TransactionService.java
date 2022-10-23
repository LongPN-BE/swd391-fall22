package com.groupswd391.fall22.Transaction;

import com.groupswd391.fall22.Transaction.DTO.TransactionRequest;
import com.groupswd391.fall22.Transaction.DTO.TransactionResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public interface TransactionService {

    TransactionResponse createTransaction(TransactionRequest transactionRequest);

    TransactionResponse updateTransaction(TransactionRequest transactionRequest, int id);

    ResponseEntity<?> getTransactionById(int id);

    ResponseEntity<?> getTransactionByWallet(int id);

    ResponseEntity<?> getTransactionByOrder(int id);

    boolean deleteTransaction(int id);

    Map<String, Object> getTransactions(int page, int size);
}
