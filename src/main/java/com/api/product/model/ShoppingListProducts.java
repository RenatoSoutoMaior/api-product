package com.api.product.model;

import javax.persistence.*;
import java.math.BigInteger;

@Entity(name = "ShoppingListProducts")
public class ShoppingListProducts {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "idProduct")
    private Long idProduct;

    @Column(name = "productName")
    private String productName;

    @Column(name = "quantity")
    private BigInteger quantity;

    @Column(name = "brand")
    private String brand;

    @Column(name="listId")
    private Long listId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(Long idProduct) {
        this.idProduct = idProduct;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public BigInteger getQuantity() {
        return quantity;
    }

    public void setQuantity(BigInteger quantity) {
        this.quantity = quantity;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public Long getListId() {
        return listId;
    }

    public void setListId(Long listId) {
        this.listId = listId;
    }
}
