package com.project.restaurant.database.service;

import com.project.restaurant.database.model.Order;
import com.project.restaurant.database.model.OrderStatus;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface IAdminOrderService {

    List<Order> getAllOrders();

    @Transactional
    void updateOrderStatusService(Long orderId, OrderStatus orderStatus);

    void deleteOrderService(Long id);
}
