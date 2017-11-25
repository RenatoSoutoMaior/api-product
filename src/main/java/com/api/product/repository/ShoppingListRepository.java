package com.api.product.repository;

import com.api.product.model.ShoppingList;
import com.api.product.model.ShoppingListProducts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ShoppingListRepository extends JpaRepository<ShoppingListProducts, Long> {

    List<ShoppingListProducts> findByListId(@Param("listId") Long listId);

}