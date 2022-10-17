package com.groupswd391.fall22.Transaction;

import com.groupswd391.fall22.Transaction.DTO.TransactionRequest;
import com.groupswd391.fall22.Transaction.DTO.TransactionResponse;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public interface TransactionService {

    TransactionResponse createTransaction(TransactionRequest transactionRequest);

    TransactionResponse updateTransaction(TransactionRequest transactionRequest, int id);

    boolean deleteTransaction(int id);

    Map<String, Object> getTransactions(int page, int size);
}
