package com.api.product.controller;

import com.api.product.model.ShoppingList;
import com.api.product.repository.ShoppingListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api")
public class ShoppingListController {

    @Autowired
    ShoppingListRepository shoppingListRepository;

    @RequestMapping(value = "/shoppingList", method = RequestMethod.GET)
    public List<ShoppingList> listAll() {
        return shoppingListRepository.findAll();
    }

    @RequestMapping(value = "/shoppingList/{id}", method = RequestMethod.GET)
    public ShoppingList findById(@PathVariable("id") Long id) {
        return shoppingListRepository.findOne(id);
    }

    @RequestMapping(value = "/shoppingList/", method = RequestMethod.POST)
    public void create(@RequestBody ShoppingList shoppingList) {
        shoppingListRepository.save(shoppingList);
    }

    @RequestMapping(value = "/shoppingList/{id}", method = RequestMethod.PUT)
    public void update(@RequestBody ShoppingList shoppingList) {
        shoppingListRepository.saveAndFlush(shoppingList);
    }

    @RequestMapping(value = "/shoppingList/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable("id") Long id) {
        shoppingListRepository.delete(id);
    }
}