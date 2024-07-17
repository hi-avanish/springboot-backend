package com.example.demo.controllers;

import com.example.demo.model.GroceryItem;
import com.example.demo.repository.ItemRepository;
import com.example.demo.services.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/grocery")
public class GroceryController {
    @Autowired
    private ItemService itemService;
    @Autowired
    ItemRepository groceryItemRepo;
    @RequestMapping()
    public List<GroceryItem> getAll(){
        // test
        return itemService.findAll();
    }
    @RequestMapping("/{name}")
    public GroceryItem getAllItems(String name){

        return itemService.findItemByName(name);
    }

    @GetMapping("/HTTP_500")
    public ResponseEntity<String> getHTTP_500() {
        try {
            // This might throw an exception...
           // businessLogic.doBusinessLogic();
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error");
        } catch (Exception e) {
            // You should log the exception here!
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error");
        }
    }
    @GetMapping("/HTTP_BadRequest")
    public ResponseEntity<String> getHTTP_Bad() {
        try {
            // This might throw an exception...
            // businessLogic.doBusinessLogic();
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body("Error: Bad request");
        } catch (Exception e) {
            // You should log the exception here!
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error");
        }
    }
    @RequestMapping("/category/{category}")
    public List<GroceryItem> getItemsByCategory(String category){
        return itemService.findByCategory(category);
    }
    @PostMapping()
    public GroceryItem insertItem(@RequestBody GroceryItem item){
        return itemService.createItem(item);
    }

    void createGroceryItems() {
        System.out.println("Data creation started...");
        groceryItemRepo.save(new GroceryItem("Whole Wheat Biscuit", "Whole Wheat Biscuit", 5, "snacks"));
        groceryItemRepo.save(new GroceryItem("Kodo Millet", "XYZ Kodo Millet healthy", 2, "millets"));
        groceryItemRepo.save(new GroceryItem("Dried Red Chilli", "Dried Whole Red Chilli", 2, "spices"));
        groceryItemRepo.save(new GroceryItem("Pearl Millet", "Healthy Pearl Millet", 1, "millets"));
        groceryItemRepo.save(new GroceryItem("Cheese Crackers", "Bonny Cheese Crackers Plain", 6, "snacks"));
        System.out.println("Data creation complete...");
    }
}
