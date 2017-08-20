package com.api.product.controller;

import com.api.product.model.Product;
import com.api.product.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductController {

    @Autowired
    ProductRepository productRepository;

    @RequestMapping(value = "/product", method = RequestMethod.GET)
    public List<Product> findAllProduct() {
        return productRepository.findAll();
    }
}
