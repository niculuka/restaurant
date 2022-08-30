package com.project.restaurant.database.service;

import com.project.restaurant.database.model.Product;

import java.util.List;
import java.util.Optional;

public interface IAdminProductService {

    Product saveProduct(Product product);

    List<Product> findAllProducts();

//    Optional<Product> findByIdService(Long id);

    Optional<Product> findByName(String linkName);

    void deleteProduct(Long id);

}
