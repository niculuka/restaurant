package com.project.restaurant.database.repository;

import com.project.restaurant.database.model.Order;
import com.project.restaurant.database.model.OrderStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface IAdminOrderRepository extends JpaRepository<Order, Long>   {

    @Modifying
    @Query("update Order set status = :status where id = :id")
    void updateOrderStatus(
            @Param("id") Long orderId,
            @Param("status") OrderStatus orderStatus
    );

}
