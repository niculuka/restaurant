package com.project.restaurant.database.service;

import com.project.restaurant.database.model.Order;

import java.util.List;

public interface IOrderService {

    Order saveOrder(Order order);

    List<Order> findMyOrdersService(Long id);

}
