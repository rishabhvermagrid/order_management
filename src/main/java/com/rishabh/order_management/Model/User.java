package com.rishabh.order_management.Model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String name;
    private String email;
    @OneToMany(
            mappedBy = "user", //Hibernate should look at user field inside Order
            cascade = CascadeType.ALL, //if you save user,all orders also save automatically.
            fetch = FetchType.LAZY //Orders are NOT loaded immediately. Only loaded when: user.getOrders()
    )
    private List<Order> orders = new ArrayList<>();

    public User(){}
    public User(Integer id, List<Order> orders, String email, String name) {
        this.id = id;
        this.orders = orders;
        this.email = email;
        this.name = name;
    }

    public void addOrder(Order order) {
        orders.add(order);
        order.setUser(this);
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }




}
