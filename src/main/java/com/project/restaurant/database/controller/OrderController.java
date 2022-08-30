package com.project.restaurant.database.controller;

import com.project.restaurant.database.model.Order;
import com.project.restaurant.database.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("")
public class OrderController {

    @Autowired
    private IOrderService orderService;


    @PostMapping("/order")
    public ResponseEntity<?> createOrder(@RequestBody Order order) {
        return new ResponseEntity<>(orderService.saveOrder(order), HttpStatus.CREATED);
    }

    @GetMapping("/order/{id}")
    public ResponseEntity<?> getMyOrders(@PathVariable Long id) {
        return new ResponseEntity<>(orderService.findMyOrdersService(id), HttpStatus.OK);
    }
}
