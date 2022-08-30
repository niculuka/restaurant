package com.project.restaurant.database.repository;

import com.project.restaurant.database.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IOrderRepository extends JpaRepository<Order, Long> {

    @Query(value = "select * from orders where user_id_get = :id", nativeQuery = true)
    List<Order> findByUserIdGet(@Param("id") Long id);

}
