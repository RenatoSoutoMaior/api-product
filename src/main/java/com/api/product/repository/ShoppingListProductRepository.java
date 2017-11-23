package com.api.product.repository;

import com.api.product.model.ShoppingList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShoppingListProductRepository extends JpaRepository<ShoppingList, Long> {
}