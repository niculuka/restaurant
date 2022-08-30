package com.project.restaurant.database.repository;

import com.project.restaurant.database.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IAdminProductRepository extends JpaRepository<Product, Long>  {

    Optional<Product> findByLinkName(String linkName);

}
