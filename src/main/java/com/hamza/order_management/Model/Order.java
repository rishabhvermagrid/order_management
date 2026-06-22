package com.hamza.order_management.Model;

import jakarta.persistence.*;

@Entity
@Table(name = "Orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String productName;
    private double price;
    private Integer quantity;
    @ManyToOne //eager by default
    @JoinColumn(name="user_id")//foreign key user_id points to Users.id
    private User user;

    public Order() {}

    public Order(String productName, double price, Integer quantity, Integer id) {
        this.productName = productName;
        this.price = price;
        this.quantity = quantity;
        this.id = id;
    }

    public Order(String productName, double price, Integer quantity, User user) {
        this.productName = productName;
        this.price = price;
        this.quantity = quantity;
        this.user = user;
    }

    public Integer getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }


}
