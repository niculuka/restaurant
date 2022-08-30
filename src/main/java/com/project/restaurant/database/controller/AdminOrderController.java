package com.project.restaurant.database.controller;

import com.project.restaurant.database.model.OrderStatus;
import com.project.restaurant.database.service.IAdminOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("admin")
public class AdminOrderController {

    @Autowired
    private IAdminOrderService adminOrderService;



    @GetMapping("/orders")
    public ResponseEntity<?> findAllOrders() {
        return new ResponseEntity<>(adminOrderService.getAllOrders(), HttpStatus.OK);
    }

    @PutMapping("/status/{orderStatus}")
    public ResponseEntity<?> changeStatus(@RequestBody Long orderId, @PathVariable OrderStatus orderStatus) {
        adminOrderService.updateOrderStatusService(orderId, orderStatus);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/orders/{id}")
    public ResponseEntity<?> deleteOrder(@PathVariable Long id) {
        adminOrderService.deleteOrderService(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
