package com.project.restaurant.database.service;

import com.project.restaurant.database.model.Item;
import com.project.restaurant.database.repository.IItemRepository;
import org.springframework.stereotype.Service;

@Service
public class ItemService implements IItemService {

    private final IItemRepository itemRepository;

    public ItemService(IItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    @Override
    public Item saveItem(Item item) {
        return itemRepository.save(item);
    }

}
