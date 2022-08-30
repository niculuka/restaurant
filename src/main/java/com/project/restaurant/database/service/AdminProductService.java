package com.project.restaurant.database.service;

import com.project.restaurant.database.model.Product;
import com.project.restaurant.database.repository.IAdminProductRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class AdminProductService implements IAdminProductService {

    private final IAdminProductRepository adminProductRepository;

    public AdminProductService(IAdminProductRepository adminProductRepository) {
        this.adminProductRepository = adminProductRepository;
    }



    @Override
    public Product saveProduct(Product product) {
        product.setCreateTime(LocalDateTime.now());
        return adminProductRepository.save(product);
    }

    @Override
    public List<Product> findAllProducts() {
        return adminProductRepository.findAll();
    }

//    @Override
//    public Optional<Product> findByIdService(Long id) {
//        return adminProductRepository.findById(id);
//    }

    @Override
    public Optional<Product> findByName(String linkName) {
        return adminProductRepository.findByLinkName(linkName);
    }

    @Override
    public void deleteProduct(Long id) {
        adminProductRepository.deleteById(id);
    }

}
