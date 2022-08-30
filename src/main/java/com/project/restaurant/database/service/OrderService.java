package com.project.restaurant.database.service;

import com.project.restaurant.database.model.Order;
import com.project.restaurant.database.repository.IOrderRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class OrderService implements IOrderService {

    private final IOrderRepository orderRepository;

    public OrderService(IOrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }



    @Override
    public Order saveOrder(Order order) {
        order.setCreatedAt(LocalDateTime.now());
        return orderRepository.save(order);
    }

    @Override
    public List<Order> findMyOrdersService(Long id) {
        return orderRepository.findByUserIdGet(id);
    }

}
