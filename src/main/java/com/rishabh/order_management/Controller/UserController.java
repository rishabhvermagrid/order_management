package com.rishabh.order_management.Controller;

import com.rishabh.order_management.DTO.UserResponseDTO;
import com.rishabh.order_management.DTO.UserRequestDTO;
import com.rishabh.order_management.Model.User;
import com.rishabh.order_management.Service.UserService;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<UserResponseDTO> createUser(@Valid @RequestBody UserRequestDTO request) {
        UserResponseDTO user =  userService.createUser(request);
        return ResponseEntity.status(201).body(user);
    }

    // get user by id
    @GetMapping("/{id}")
    public ResponseEntity<UserResponseDTO> getUser(
            @PathVariable int id) {

        return ResponseEntity.ok(
                userService.getUserById(id)
        );
    }


    // get all users
    @GetMapping
    public List<UserResponseDTO> getAllUsers() {
        return userService.getAllUsers();
    }



    @PutMapping("/{id}")
    public ResponseEntity<UserResponseDTO> updateUser(
            @PathVariable int id,
            @Valid @RequestBody UserRequestDTO request
    ) {

        return ResponseEntity.ok(
                userService.updateUser(id, request)
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(
            @PathVariable int id) {

        userService.deleteUser(id);

        return ResponseEntity.noContent().build();
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
    public ResponseEntity<Page<User>> getUsersPaginated(
            Pageable pageable) {

        return ResponseEntity.ok(
                userService.getUsersPaginated(pageable)
        );
    }
}
