package com.project.restaurant.database.controller;

import com.project.restaurant.database.service.IAdminItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("admin")
public class AdminItemController {

    @Autowired
    private IAdminItemService adminItemService;



    @GetMapping("/items")
    public ResponseEntity<?> findAllItems() {
        return new ResponseEntity<>(adminItemService.getItemsService(), HttpStatus.OK);
    }

    @DeleteMapping("/items/{id}")
    public ResponseEntity<?> deleteItem(@PathVariable Long id) {
        adminItemService.deleteItemService(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
