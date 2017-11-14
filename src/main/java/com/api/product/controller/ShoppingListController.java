package com.api.product.controller;

import com.api.product.model.ShoppingList;
import com.api.product.repository.ShoppingListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ShoppingListController {

    @Autowired
    ShoppingListRepository shoppingListRepository;

    @GetMapping(value = "/shoppingList")
    public List<ShoppingList> listAll() {
        return shoppingListRepository.findAll();
    }

    @GetMapping(value = "/shoppingList/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ShoppingList findById(@PathVariable("id") Long id) {
        return shoppingListRepository.findOne(id);
    }

    @PostMapping(value = "/shoppingList")
    public void create(@RequestBody ShoppingList shoppingList) {
        shoppingListRepository.save(shoppingList);
    }

    @PutMapping(value = "/shoppingList/{id}")
    public void update(@RequestBody ShoppingList shoppingList) {
        shoppingListRepository.saveAndFlush(shoppingList);
    }

    @DeleteMapping(value = "/shoppingList/{id}")
    public void delete(@PathVariable("id") Long id) {
        shoppingListRepository.delete(id);
    }
}