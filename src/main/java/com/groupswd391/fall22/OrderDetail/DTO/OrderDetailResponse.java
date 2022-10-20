package com.groupswd391.fall22.OrderDetail.DTO;

import com.groupswd391.fall22.Order.Order;
import com.groupswd391.fall22.OrderDetail.OrderDetail;
import com.groupswd391.fall22.ProjectItem.ProjectItem;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderDetailResponse {
    private int id;
    private Order order;
    private ProjectItem projectItem;

    public static OrderDetailResponse buildFromOrderDetail(OrderDetail orderDetail) {
        return new OrderDetailResponse(
                orderDetail.getId(),
                orderDetail.getOrder(),
                orderDetail.getProjectItem()
        );
    }
}
