package com.api.product.controller;

import com.api.product.model.Category;
import com.api.product.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
public class CategoryController {

    @Autowired
    CategoryRepository categoryRepository;

    @GetMapping(value = "/product/category")
    public List<Category> listAll() {
        return categoryRepository.findAll();
    }

    @GetMapping(value = "/product/category/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Category findById(@PathVariable("id") BigDecimal id) {
        return categoryRepository.findOne(id);
    }

    @PostMapping(value = "/product/category")
    public void create(@RequestBody Category product) {
        categoryRepository.save(product);
    }

    @PutMapping(value = "/product/category/{id}")
    public void update(@RequestBody Category product) {
        categoryRepository.saveAndFlush(product);
    }

    @DeleteMapping(value = "/product/category/{id}")
    public void delete(@PathVariable("id") BigDecimal id) {
        categoryRepository.delete(id);
    }
}