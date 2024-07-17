package com.example.demo.services;

import com.example.demo.model.GroceryItem;
import com.example.demo.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemServiceImp implements ItemService {
    @Autowired
    private ItemRepository itemRepository;
    @Override
    public List<GroceryItem> findAll() {
        return itemRepository.findAll();
    }

    @Override
    public GroceryItem findItemByName(String name) {
        return itemRepository.findItemByName(name);
    }

    @Override
    public List<GroceryItem> findByCategory(String category) {
        return itemRepository.findByCategory(category);
    }

    @Override
    public GroceryItem createItem(GroceryItem groceryItem) {
        return itemRepository.save(groceryItem);
    }

}
