package com.project.restaurant.database.controller;

import com.project.restaurant.database.model.Category;
import com.project.restaurant.database.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("")
public class ProductController {

    @Autowired
    private IProductService productService;



    @GetMapping("/product/{linkName}")
    public ResponseEntity<?> getProductByName(@PathVariable String linkName) {
        return new ResponseEntity<>(productService.findByName(linkName), HttpStatus.OK);
    }

    //Category category;
    @GetMapping("/products/{categoryAsString}")
    public ResponseEntity<?> getProductByCategory(@PathVariable String categoryAsString) {
        Category category = Category.getCategory(categoryAsString);
        return new ResponseEntity<>(productService.findProductsByCategoryService(category), HttpStatus.OK);
    }

}
