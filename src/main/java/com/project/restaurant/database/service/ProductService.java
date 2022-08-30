package com.project.restaurant.database.service;

import com.project.restaurant.database.model.Category;
import com.project.restaurant.database.model.Product;
import com.project.restaurant.database.repository.IProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService implements IProductService {

    private final IProductRepository productRepository;

    public ProductService(IProductRepository productRepository) {
        this.productRepository = productRepository;
    }



    @Override
    public Optional<Product> findByName(String linkName) {
        return productRepository.findByLinkName(linkName);
    }

    @Override
    public List<Product> findProductsByCategoryService(Category category) {
        return productRepository.findProductsByCategory(category);
    }

//    @Override
//    public Optional<Product> findProductByIdService(Long id) {
//        return productRepository.findById(id);
//    }




}
