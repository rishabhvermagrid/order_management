package com.rishabh.order_management.Service;


import com.rishabh.order_management.DTO.UserResponseDTO;
import com.rishabh.order_management.DTO.UserRequestDTO;
import com.rishabh.order_management.Exception.UserNotFoundException;
import com.rishabh.order_management.Model.User;
import com.rishabh.order_management.Repository.UserRepository;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

//controller->service->repository->database
@Service //marks class as spring bean
public class UserService {
    //userService needs userRepo
    public final UserRepository userRepository;
    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    //save user
    public UserResponseDTO createUser(UserRequestDTO request) {
        User user = new User();
        user.setName(request.getName());
        user.setEmail(request.getEmail());
        User savedUser = userRepository.save(user);

        return new UserResponseDTO(
                savedUser.getId(),
                savedUser.getName(),
                savedUser.getEmail()
        );
    }

    //get all users
    public List<UserResponseDTO> getAllUsers(){
        return userRepository.findAll().stream()
                .map(user->new UserResponseDTO(
                        user.getId(),
                        user.getName(),
                        user.getEmail()
                )).toList();
    }

    //get user by id
    //check findById definition, it returns optional, because the user may or may not exist,if user exists Optional[user], if not exist Optional.empty
    //This means: orElseThrow() If user is present → return the user, If user is absent → throw exception
    public UserResponseDTO getUserById(int id){
        User user =  userRepository.findById(id)
                .orElseThrow(()->
                        new UserNotFoundException("User not found"));
        return new UserResponseDTO(
                user.getId(),
                user.getName(),
                user.getEmail()
        );
    }

    //delete user
    public void deleteUser(int id){
        userRepository.deleteById(id);
    }

    //jpql
    public List<User> getUsersJPQL() {
        return userRepository.getAllUsersJPQL();
    }

    public List<User> searchUser(String name){
        return  userRepository.findByName(name);
    }
    public List<User> seachUsingEmail(String email){
        return userRepository.findByEmail(email);
    }
    public org.springframework.data.domain.Page<User> getUsersPaginated(int page,int size){
        Pageable pageable = PageRequest.of(page, size);
        return userRepository.findAll(pageable);
    }



}
