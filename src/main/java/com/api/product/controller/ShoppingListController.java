package com.api.product.controller;

import com.api.product.model.ShoppingListProducts;
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
    public List<ShoppingListProducts> listAll() {
        return shoppingListRepository.findAll();
    }

    @RequestMapping(value = "/shoppingList/list/{id}", method = RequestMethod.GET)
    public List<ShoppingListProducts> listAllForListId(@PathVariable Long id) {
        return shoppingListRepository.findByListId(id);
    }

    @RequestMapping(value = "/shoppingList/{id}", method = RequestMethod.GET)
    public ShoppingListProducts findById(@PathVariable("id") Long id) {
        return shoppingListRepository.findOne(id);
    }

    @RequestMapping(value = "/shoppingList/", method = RequestMethod.POST)
    public List<ShoppingListProducts> create(@RequestBody ShoppingListProducts shoppingList) {
        shoppingListRepository.save(shoppingList);
        return shoppingListRepository.findByListId(shoppingList.getListId());
    }

    @RequestMapping(value = "/shoppingList/{id}", method = RequestMethod.PUT)
    public void update(@RequestBody ShoppingListProducts shoppingList) {
        shoppingListRepository.saveAndFlush(shoppingList);
    }

    @RequestMapping(value = "/shoppingList/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable("id") Long id) {
        shoppingListRepository.delete(id);
    }
}