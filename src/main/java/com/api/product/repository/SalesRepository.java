package com.api.product.repository;

import com.api.product.model.Sale;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public interface SalesRepository extends JpaRepository<Sale, Long>{
	
	@Query("SELECT s FROM Sale s WHERE s.price BETWEEN :price AND :price2 ORDER BY s.price")
	List<Sale> findByPrice(@Param("price") BigDecimal price,@Param("price2") BigDecimal price2);
	
	@Query("SELECT s FROM Sale s WHERE s.inicialDate BETWEEN :inicialDate AND :lastDate ORDER BY s.inicialDate")
	List<Sale> findByDate(@Param("inicialDate")Date inicialDate,@Param("lastDate")Date lastDate);
}
