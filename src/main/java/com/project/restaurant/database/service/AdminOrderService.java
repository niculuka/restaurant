package com.project.restaurant.database.service;

import com.project.restaurant.database.model.Order;
import com.project.restaurant.database.model.OrderStatus;
import com.project.restaurant.database.repository.IAdminOrderRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class AdminOrderService implements IAdminOrderService {

    private final IAdminOrderRepository adminOrderRepository;

    public AdminOrderService(IAdminOrderRepository adminOrderRepository) {
        this.adminOrderRepository = adminOrderRepository;
    }



    @Override
    public List<Order> getAllOrders() {
        return  adminOrderRepository.findAll();
    }

    @Transactional
    @Override
    public void updateOrderStatusService(Long orderId, OrderStatus orderStatus) {
        adminOrderRepository.updateOrderStatus(orderId, orderStatus);
    }

    @Override
    public void deleteOrderService(Long id) {
        adminOrderRepository.deleteById(id);
    }

}
