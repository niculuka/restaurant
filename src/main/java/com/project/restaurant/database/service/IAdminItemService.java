package com.project.restaurant.database.service;

import com.project.restaurant.database.model.Item;

import java.util.List;

public interface IAdminItemService {

    List<Item> getItemsService();

    void deleteItemService(Long id);

}
