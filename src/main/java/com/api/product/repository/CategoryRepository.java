package com.api.product.repository;

import com.api.product.model.Category;
import com.api.product.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;

@Repository
public interface CategoryRepository extends JpaRepository<Category, BigDecimal> {

}
