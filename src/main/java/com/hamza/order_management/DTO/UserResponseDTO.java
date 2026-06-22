package com.hamza.order_management.DTO;

public class UserResponseDTO {

    private int id;
    private String name;
    private String email;
    private String userName;


    public UserResponseDTO() {
    }

    public UserResponseDTO(int id,
                           String name,
                           String email,
                           String userName) {

        this.id = id;
        this.name = name;
        this.email = email;
        this.userName = userName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}