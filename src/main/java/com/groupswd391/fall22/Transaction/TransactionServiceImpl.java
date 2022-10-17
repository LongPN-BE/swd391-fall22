package com.groupswd391.fall22.Transaction;


import com.groupswd391.fall22.Order.Order;
import com.groupswd391.fall22.Order.OrderRepository;
import com.groupswd391.fall22.Transaction.DTO.TransactionRequest;
import com.groupswd391.fall22.Transaction.DTO.TransactionResponse;
import com.groupswd391.fall22.Wallet.Wallet;
import com.groupswd391.fall22.Wallet.WalletRepository;
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
public class TransactionServiceImpl implements TransactionService {
    final
    TransactionRepository transactionRepository;
    final
    OrderRepository orderRepository;
    final
    WalletRepository walletRepository;
    final
    ModelMapper modelMapper;

    public TransactionServiceImpl(TransactionRepository transactionRepository, OrderRepository orderRepository, WalletRepository walletRepository, ModelMapper modelMapper) {
        this.transactionRepository = transactionRepository;
        this.orderRepository = orderRepository;
        this.walletRepository = walletRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public TransactionResponse createTransaction(TransactionRequest transactionRequest) {
        Transaction transaction = modelMapper.map(transactionRequest, Transaction.class);
        Order order = orderRepository.findById(transactionRequest.getOrderID()).orElseThrow(
                () -> new ResourceNotFoundException("Not found Order")
        );
        Wallet wallet = walletRepository.findById(transactionRequest.getWalletId()).orElseThrow(
                () -> new ResourceNotFoundException("Not found Order")
        );
        transaction.setOrder(order);
        transaction.setWallet(wallet);
        Transaction saveTransaction = transactionRepository.save(transaction);
        return TransactionResponse.buildFromTransaction(saveTransaction);
    }

    @Override
    public TransactionResponse updateTransaction(TransactionRequest transactionRequest, int id) {
        Transaction oldTransaction = transactionRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Not found Transaction")
        );
        Order order = orderRepository.findById(transactionRequest.getOrderID()).orElseThrow(
                () -> new ResourceNotFoundException("Not found Order")
        );
        Wallet wallet = walletRepository.findById(transactionRequest.getWalletId()).orElseThrow(
                () -> new ResourceNotFoundException("Not found Wallet")
        );
        modelMapper.map(transactionRequest, oldTransaction);
        oldTransaction.setOrder(order);
        oldTransaction.setWallet(wallet);
        Transaction saveTransaction = transactionRepository.save(oldTransaction);
        return TransactionResponse.buildFromTransaction(saveTransaction);
    }

    @Override
    public boolean deleteTransaction(int id) {
        Transaction transaction = transactionRepository.findById(id).orElseThrow(
                () -> new NotFoundException("Not found Transaction")
        );
        transactionRepository.deleteById(id);
        return true;
    }

    @Override
    public Map<String, Object> getTransactions(int page, int size) {
        List<Transaction> transactions = null;
        Pageable paging = PageRequest.of(page, size);
        Page<Transaction> pageTuts = null;
        pageTuts = transactionRepository.findAll(paging);
        transactions = pageTuts.getContent();

        Map<String, Object> response = new HashMap<>();
        response.put("transactions", transactions);
        response.put("currentPage", pageTuts.getNumber());
        response.put("totalItems", pageTuts.getTotalElements());
        response.put("totalPages", pageTuts.getTotalPages());
        return response;
    }
}
