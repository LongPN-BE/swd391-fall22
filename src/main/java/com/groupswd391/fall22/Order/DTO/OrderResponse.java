package com.groupswd391.fall22.Order.DTO;

import com.groupswd391.fall22.Application.Application;
import com.groupswd391.fall22.Order.Order;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderResponse {
private int id;
private Application application;
private Date time;
private double amount;

    public static OrderResponse buildFromOrder(Order order) {
        return new OrderResponse(
                order.getId(),
                order.getApplication(),
                order.getTime(),
                order.getAmount()
        );
    }
}
