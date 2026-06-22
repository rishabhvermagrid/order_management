package com.hamza.order_management.Model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String user_name;
    private String name;
    private String email;



    private String password;
    @OneToMany(
            mappedBy = "user", //Hibernate should look at user field inside Order
            cascade = CascadeType.ALL, //if you save user,all orders also save automatically.
            fetch = FetchType.LAZY //Orders are NOT loaded immediately. Only loaded when: user.getOrders()
    )
    private List<Order> orders = new ArrayList<>();

    public User(){}
    public User(Integer id, List<Order> orders, String email, String name, String userName,String password) {
        this.id = id;
        this.orders = orders;
        this.email = email;
        this.name = name;
        this.user_name = userName;
        this.password = password;
    }


    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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
    public void setUserName(String userName){
        this.user_name = userName;
    }
    public String getUserName(){
        return user_name;
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
