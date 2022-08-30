package com.project.restaurant.database.repository;

import com.project.restaurant.database.model.Category;
import com.project.restaurant.database.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface IProductRepository extends JpaRepository<Product, Long> {

    Optional<Product> findByLinkName(String linkName);

    List<Product> findProductsByCategory(Category category);

}
