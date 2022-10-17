package com.groupswd391.fall22.Transaction.DTO;

import com.groupswd391.fall22.Order.Order;
import com.groupswd391.fall22.Transaction.Transaction;
import com.groupswd391.fall22.Wallet.Wallet;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class TransactionResponse {
    private int id;
    private Order order;
    private Wallet wallet;

    public static TransactionResponse buildFromTransaction(Transaction transaction) {
        return new TransactionResponse(
                transaction.getId(),
                transaction.getOrder(),
                transaction.getWallet()
        );
    }

}
