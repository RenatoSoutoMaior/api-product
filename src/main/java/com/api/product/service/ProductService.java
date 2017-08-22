package com.api.product.service;

import com.api.product.model.Product;
import com.api.product.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public List<Product> findAll() {
        return this.productRepository.findAll();
    }

    public Product findById(BigDecimal id) {
        return this.productRepository.findOne(id);
    }

    public void save(Product product) {
        this.productRepository.save(product);
    }

    public void update(Product product) {
        this.productRepository.save(product);
    }

    public void deleteById(BigDecimal id) {
        this.productRepository.delete(id);
    }

    public Product set(Product product, Product currentProduct) {
        currentProduct.setName(product.getName());
        currentProduct.setDescription(product.getDescription());
        currentProduct.setPrice(product.getPrice());
        currentProduct.setQuantity(product.getQuantity());
        currentProduct.setCategory(product.getCategory());
        currentProduct.setStatus(product.getStatus());
        currentProduct.setImage(product.getImage());
        return currentProduct;
    }

    public boolean isExist(Product product) {
        return (findById(product.getId()) != null);
    }
}
