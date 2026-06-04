package com.rishabh.order_management.Controller;

import com.rishabh.order_management.DTO.UserResponseDTO;
import com.rishabh.order_management.DTO.UserRequestDTO;
import com.rishabh.order_management.Model.User;
import com.rishabh.order_management.Service.UserService;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController{
    private final UserService userService;
    public UserController(UserService userService){
        this.userService  = userService;
    }

    @PostMapping
    public UserResponseDTO createUser(@Valid @RequestBody UserRequestDTO request) {
        return userService.createUser(request);
    }

    // get all users
    @GetMapping
    public List<UserResponseDTO> getAllUsers() {
        return userService.getAllUsers();
    }

    // get user by id
    @GetMapping("/{id}")
    public UserResponseDTO getUser(@PathVariable int id) {
        return userService.getUserById(id);
    }

    // update user
    @PutMapping("/{id}")
    public UserResponseDTO updateUser(
            @PathVariable int id,
            @Valid @RequestBody UserRequestDTO request
    ) {
        return userService.updateUser(id, request);
    }

    // delete user
    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable int id) {
        userService.deleteUser(id);
        return "User deleted";
    }

    //jpql
    @GetMapping("/jpql")
    public List<User> getUsersJPQL() {
        return userService.getUsersJPQL();
    }


    @GetMapping("/search")
    public List<User> searchUser(
            @RequestParam String name
    ) {
        return userService.searchUser(name);
    }

    @GetMapping("/email")
    public List<User> searchEmail(@RequestParam String email){
        return userService.seachUsingEmail(email);
    }

    @GetMapping("/pagination")
    public Page<User> getUsersPaginated(Pageable pageable) {
        return userService.getUsersPaginated(pageable);
    }
}
