package com.project.restaurant.database.controller;

import com.project.restaurant.database.model.Product;
import com.project.restaurant.database.service.IAdminProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("admin")
public class AdminProductController {

    @Autowired
    private IAdminProductService adminProductService;



    @PostMapping("/products")
    public ResponseEntity<?> saveProduct(@RequestBody Product product) {
        if (adminProductService.findByName(product.getName()).isPresent()) {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
        return new ResponseEntity<>(adminProductService.saveProduct(product), HttpStatus.CREATED);
    }

    @GetMapping("/products")
    public ResponseEntity<?> getAllProducts() {
        return new ResponseEntity<>(adminProductService.findAllProducts(), HttpStatus.OK);
    }

//    @GetMapping("/products/{id}")
//    public ResponseEntity<?> findByIdController(@PathVariable Long id) {
//        return new ResponseEntity<>(adminProductService.findByIdService(id), HttpStatus.OK);
//    }

    @PutMapping("/products")
    public ResponseEntity<?> updateProduct(@RequestBody Product product) {
        return new ResponseEntity<>(adminProductService.saveProduct(product), HttpStatus.CREATED);
    }

    @DeleteMapping("/products/{id}")
    public ResponseEntity<?> deleteProduct(@PathVariable Long id) {
        adminProductService.deleteProduct(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
