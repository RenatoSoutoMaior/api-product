package com.api.product.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigInteger;
import java.time.LocalDate;

@Entity
@Table(name = "shoppingList")
public class ShoppingList {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "notification")
    private Boolean notification;

    @Column(name = "weekly")
    private Boolean weekly;

    @Column(name = "monthly")
    private Boolean monthly;

    @Column(name = "onlyOnce")
    private Boolean onlyOnce;

    @Column(name = "date")
    private LocalDate date;

    @Column(name = "dayWeek")
    private String dayWeek;

    @Column(name = "dayMonth")
    private Integer dayMonth;

    @Column(name = "color")
    private String color;

    @Column(name = "idProduct")
    private Long idProduct;

    @Column(name = "productName")
    private String productName;

    @Column(name = "quantity")
    private BigInteger quantity;

    @Column(name = "brand")
    private String brand;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getNotification() {
        return notification;
    }

    public void setNotification(Boolean notification) {
        this.notification = notification;
    }

    public Boolean getWeekly() {
        return weekly;
    }

    public void setWeekly(Boolean weekly) {
        this.weekly = weekly;
    }

    public Boolean getMonthly() {
        return monthly;
    }

    public void setMonthly(Boolean monthly) {
        this.monthly = monthly;
    }

    public Boolean getOnlyOnce() {
        return onlyOnce;
    }

    public void setOnlyOnce(Boolean onlyOnce) {
        this.onlyOnce = onlyOnce;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getDayWeek() {
        return dayWeek;
    }

    public void setDayWeek(String dayWeek) {
        this.dayWeek = dayWeek;
    }

    public Integer getDayMonth() {
        return dayMonth;
    }

    public void setDayMonth(Integer dayMonth) {
        this.dayMonth = dayMonth;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
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
}
