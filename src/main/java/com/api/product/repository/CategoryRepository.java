package com.api.product.repository;

import com.api.product.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface CategoryRepository extends JpaRepository<Category, BigDecimal> {
    List<Category> findByNameContainingIgnoreCase(@Param("name") String name);
}
