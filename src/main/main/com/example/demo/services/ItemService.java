package com.example.demo.services;

import com.example.demo.model.GroceryItem;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface ItemService {
    List<GroceryItem> findAll();
    GroceryItem findItemByName(String name);
    @Query(value="{category:'?0'}", fields="{'name' : 1, 'quantity' : 1}")
    List<GroceryItem> findByCategory(String category);

    GroceryItem createItem(GroceryItem groceryItem);

}
