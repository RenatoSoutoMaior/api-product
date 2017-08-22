package com.api.product.controller;

import com.api.product.model.Product;
import com.api.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
public class ProductController {

    @Autowired
    ProductService productService;

    @GetMapping(value = "/product/")
    public ResponseEntity<List<Product>> listAllProducts() {
        List<Product> products = productService.findAll();
        if (products.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(products, HttpStatus.OK);
    }

    @GetMapping(value = "/product/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Product> getProduct(@PathVariable("id") BigDecimal id) {
        Product product = productService.findById(id);
        if (product == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(product, HttpStatus.OK);
    }

    @PostMapping(value = "/product/")
    public ResponseEntity<Void> createProduct(@RequestBody Product product) {

        if (productService.isProductExist(product)) {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
        productService.saveProduct(product);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping(value = "/product/{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable("id") BigDecimal id, @RequestBody Product product) {

        Product currentProduct = productService.findById(id);

        if (productService.isProductExist(currentProduct)) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        productService.updateProduct(productService.setProduct(product, currentProduct));
        return new ResponseEntity<>(currentProduct, HttpStatus.OK);
    }

    @DeleteMapping(value = "/product/{id}")
    public ResponseEntity<Product> deleteProduct(@PathVariable("id") BigDecimal id) {

        Product product = productService.findById(id);
        if (productService.isProductExist(product)) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        productService.deleteProductById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
