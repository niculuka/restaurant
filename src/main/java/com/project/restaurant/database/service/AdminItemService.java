package com.project.restaurant.database.service;

import com.project.restaurant.database.model.Item;
import com.project.restaurant.database.repository.IAdminItemRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class AdminItemService implements IAdminItemService {

    private final IAdminItemRepository adminItemRepository;



    @Override
    public List<Item> getItemsService() {
        return  adminItemRepository.findAll();
    }

    @Override
    public void deleteItemService(Long id) {
        adminItemRepository.deleteById(id);
    }
}
