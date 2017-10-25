package com.api.product.controller;

import com.api.product.model.Product;
import com.api.product.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {

    @Autowired
    ProductRepository productRepository;

    @GetMapping(value = "/product")
    public List<Product> listAll() {
        return productRepository.findAll();
    }

    @GetMapping(value = "/product/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Product findById(@PathVariable("id") Long id) {
        return productRepository.findOne(id);
    }

    @GetMapping(value = "/api/product/{name}", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Product> findByName(@PathVariable("name") String name) {
        return productRepository.findByNameContainingIgnoreCase(name);
    }

    @PostMapping(value = "/product")
    public void create(@RequestBody Product product) {
        productRepository.save(product);
    }

    @PutMapping(value = "/product/{id}")
    public void update(@RequestBody Product product) {
        productRepository.saveAndFlush(product);
    }

    @DeleteMapping(value = "/product/{id}")
    public void delete(@PathVariable("id") Long id) {
        productRepository.delete(id);
    }
}