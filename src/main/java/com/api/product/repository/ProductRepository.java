package com.api.product.repository;

import com.api.product.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, BigDecimal> {
    List<Product> findByNameContainingIgnoreCase(@Param("name") String name);
}