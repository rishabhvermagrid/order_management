package com.hamza.order_management.Repository;

import com.hamza.order_management.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User,Integer>{
    List<User> findByNameContainingIgnoreCase(String name);
    //Learning JPQL
    @Query("SELECT u FROM User u")
    List<User> getAllUsersJPQL();

    @Query("SELECT u FROM User u WHERE u.name = :name")
    List<User> findByName(@Param("name") String name);

    @Query("SELECT u FROM User u WHERE u.email = :email")
    List<User> findByEmail(@Param("email") String email);
}


