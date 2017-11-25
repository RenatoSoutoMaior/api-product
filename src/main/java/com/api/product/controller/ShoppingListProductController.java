package com.api.product.controller;

import com.api.product.model.ShoppingList;
import com.api.product.model.ShoppingListProducts;
import com.api.product.repository.ShoppingListProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api")
public class ShoppingListProductController {

    @Autowired
    ShoppingListProductRepository shoppingListProductRepository;

    @RequestMapping(value = "/shoppingList/user/{id}", method = RequestMethod.GET)
    public List<ShoppingList> listAllForUser(@PathVariable Long id) {
        return shoppingListProductRepository.findByIdClient(id);
    }

    @RequestMapping(value = "/shopping/list/products", method = RequestMethod.GET)
    public List<ShoppingList> listAll() {
        return shoppingListProductRepository.findAll();
    }

    @RequestMapping(value = "/shopping/list/products/{id}", method = RequestMethod.GET)
    public ShoppingList findById(@PathVariable("id") Long id) {
        return shoppingListProductRepository.findOne(id);
    }

    @RequestMapping(value = "/shopping/list/products/", method = RequestMethod.POST)
    public Long create(@RequestBody ShoppingList shoppingList) {
        return shoppingListProductRepository.save(shoppingList).getId();
    }

    @RequestMapping(value = "/runner/", method = RequestMethod.POST)
    public void runner(@RequestBody ShoppingList shoppingList) {
            this.shoppingListProductRepository.save(shoppingList);
    }

    @RequestMapping(value = "/shopping/list/products/{id}", method = RequestMethod.PUT)
    public void update(@RequestBody ShoppingList shoppingList) {
        shoppingListProductRepository.saveAndFlush(shoppingList);
    }

    @RequestMapping(value = "/shopping/list/products/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable("id") Long id) {
        shoppingListProductRepository.delete(id);
    }
}