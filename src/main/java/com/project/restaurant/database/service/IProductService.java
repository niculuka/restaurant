package com.project.restaurant.database.service;

import com.project.restaurant.database.model.Category;
import com.project.restaurant.database.model.Product;

import java.util.List;
import java.util.Optional;

public interface IProductService {

    Optional<Product> findByName(String linkName);

    List<Product> findProductsByCategoryService(Category category);

//    Optional<Product> findProductByIdService(Long id);



}
